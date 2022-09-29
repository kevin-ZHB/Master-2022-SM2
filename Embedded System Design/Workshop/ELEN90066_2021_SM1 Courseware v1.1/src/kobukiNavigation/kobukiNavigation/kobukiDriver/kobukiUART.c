/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Revised:	2011-01-18
*/

#include <stdio.h>
#include <stdlib.h>

#include "kobukiUART.h"
#include "kobukiUtilities.h"



int32_t kobukiReadFeedbackPacket(MyRio_Uart * uart,  uint8_t * * packetBuffer){

	typedef enum {wait_until_AA, wait_until_55, read_length, read_payload, read_checksum} state_type;

	state_type state = wait_until_AA;

	uint8_t byteBuffer;
	int32_t status = 0;
	uint8_t payloadSize = 0;
	uint8_t calcuatedCS;
	uint8_t headers[2];
	int i = 0;

	status = Uart_Clear(uart);

	int num_checksum_failures = 0;

	while(1){

		switch(state){
			case wait_until_AA:
				status = Uart_Read(uart, headers, 2);
				if (status && status !=1073676294)
								{
								 printf("\nwait until AA status %d\n",status);
								}
				if (headers[0]==0xAA && headers[1]==0x55)
					state=read_length;
				else
					state = wait_until_AA;
					break;
			case read_length:
				byteBuffer = 0;
				status = Uart_Read(uart, &byteBuffer, 1);
				payloadSize = byteBuffer;
				state = read_payload;
				break;

			case read_payload:
				//printf("in read_payload\n");
				*packetBuffer = (uint8_t *) malloc(sizeof(uint8_t) * (payloadSize + 4) );
				memset(*packetBuffer,-1,payloadSize+3);
				status = Uart_Read(uart, (*packetBuffer) + 3, payloadSize+1);
				if (status && status !=1073676294)
				{
				 printf("\nstatus %d\n",status);
				}
				state = read_checksum;
				break;

			case read_checksum:

				//must do this before computing checksum
				(*packetBuffer)[0] = 0xAA;
				(*packetBuffer)[1] = 0x55;
				(*packetBuffer)[2] = payloadSize;

				calcuatedCS = checkSumRead(*packetBuffer, payloadSize + 3);
				byteBuffer=(*packetBuffer)[payloadSize+3];
				if (calcuatedCS == byteBuffer){
					num_checksum_failures = 0;
					return status;
				}
				else{
					free((*packetBuffer));
					state = wait_until_AA;
					if (num_checksum_failures == 3){
						printf("\nchecksum failure :%d, %d %d \n",payloadSize,calcuatedCS,byteBuffer);
						printf("3 Consecutive Checksum Failures\n");
						return -1500;
					}
					num_checksum_failures++;
				}

				break;
		}

	}
	return status;
}


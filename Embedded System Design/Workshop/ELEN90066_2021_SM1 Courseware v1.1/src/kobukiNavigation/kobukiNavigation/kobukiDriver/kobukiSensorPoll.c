/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	Methods to poll iRobot sensors.
				NOTE: Polling requires both transmitting and receiving
				to the UART port, hence these functions are *not*
				thread safe with regard to other UART functions.

	Revised:	2011-01-18
*/

#include <stdlib.h>


#include "kobukiSensor.h"
#include "kobukiSensorPoll.h"
#include "../myrio/visa.h"
//#include "UART.h"
//#include "xqueue.h"



/* Request sensor packet from iRobot and wait for response */
extern int32_t kobukiSensorPoll(
		MyRio_Uart 	*	uart_reference,				/* (in)		iRobot UART pot */
		KobukiSensors_t * const	sensors		/* (out)	Sensor group */
){
	int32_t status = 0;

	/* initialize communications buffer */
	uint8_t * packet = NULL;

	status = kobukiReadFeedbackPacket(uart_reference, &packet);
	//printf("returned from kobukiReadFeedbackPacket with status: %d\n", status);


    if (status < VI_SUCCESS)
    {
        return status;
    }
    if (packet == NULL){
    	return -1; // this is our null pointer error code
    }

	/* parse response */
    kobukiParseSensorPacket(packet, sensors);
    //printf("returned from kobukiParseSensorPacket\n");


    free(packet);


	return status;
}



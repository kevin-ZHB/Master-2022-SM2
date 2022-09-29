/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	iRobot actuator commands.

	Revised:	2011-01-18
*/

#include "kobukiActuator.h"
#include "kobukiUtilities.h"
#include <stdlib.h>
#include <math.h>
#include <stdio.h>


int32_t kobukiDriveDirect(
		MyRio_Uart * uart_reference,
		int16_t leftWheelSpeed,
		int16_t rightWheelSpeed
){


	//printf("Entering KobukiDriveDirect\n");
	int16_t CmdSpeed;
	int16_t CmdRadius;

	if (abs(rightWheelSpeed) > abs(leftWheelSpeed)) {
	    CmdSpeed = rightWheelSpeed;
	} else {
	    CmdSpeed = leftWheelSpeed;
	}

	if (rightWheelSpeed == leftWheelSpeed) {
	    CmdRadius = 0;  // Special case 0 commands Kobuki travel with infinite radius.
	} else {
	    CmdRadius = (rightWheelSpeed + leftWheelSpeed) / (2.0 * (rightWheelSpeed - leftWheelSpeed) / 123.0);  // The value 123 was determined experimentally to work, and is approximately 1/2 the wheelbase in mm.
	    CmdRadius = round(CmdRadius);
	    //if the above statement overflows a signed 16 bit value, set CmdRadius=0 for infinite radius.
	    if (CmdRadius>32767) CmdRadius=0;
	    if (CmdRadius<-32768) CmdRadius=0;
	    if (CmdRadius==0) CmdRadius=1;  // Avoid special case 0 unless want infinite radius.
	}

	if (CmdRadius == 1){
		CmdSpeed = CmdSpeed * -1;
	}

	int32_t status = kobukiDriveRadius(uart_reference,CmdRadius, CmdSpeed);


	return status;
}

uint8_t split_int16(int16_t data, int LSB){

	if (LSB){
		return data & 0x00FF;
	}else{
		return (data & 0xFF00) >> 8;
	}

}

uint16_t split_int32(int32_t data, int LSB){

	if (LSB){
		return data & 0x000FFFF;
	}else{
		return (data & 0xFFF0000) >> 16;
	}

}


int32_t kobukiDriveRadius(MyRio_Uart * uart_reference, int16_t radius, int16_t speed){

    uint8_t writeData[25];

    // Write move payload
    writeData[0] = 0xAA;
    writeData[1] = 0x55;
    writeData[2] = 0x06;
    writeData[3] = 0x01;
    writeData[4] = 0x04;
    writeData[5] = split_int16(speed, 1); // 1 is a bool in this context
    writeData[6] = split_int16(speed, 0);
    writeData[7] = split_int16(radius, 1);
	writeData[8] = split_int16(radius, 0);
	//below is set controller
	 writeData[9] = 13;
	    writeData[10] = 13;
	    writeData[11] = 0x1;
	    writeData[12] = 0xA0; //
	    writeData[13] = 0x86;
	    writeData[14] = 1;
		writeData[15] = 0;
		writeData[16] = 0;
		writeData[17] = 0;
		writeData[18] = 0;
		writeData[19] = 0;
		writeData[20] = 0;
		writeData[21] = 0;
		writeData[22] = 0;
		writeData[23] = 0;
    writeData[24] = checkSum(writeData ,24);

    int32_t status = Uart_Write(uart_reference, writeData, 25);
    return status;

}

int32_t kobukiSetController(MyRio_Uart * uart_reference, int16_t Ki, int16_t Kp,int16_t Kd){

    uint8_t writeData[18];

    // Write move payload
    writeData[0] = 0xAA;
    writeData[1] = 0x55;
    writeData[2] = 13;
    writeData[3] = 13;
    writeData[4] = 0x1;
    writeData[5] = 0xA0; // 1 is a bool in this context
    writeData[6] = 0x86;
    writeData[7] = 1;
	writeData[8] = 0;
	writeData[9] = 0;
	writeData[10] = 0;
	writeData[11] = 0;
	writeData[12] = 0;
	writeData[13] = 0;
	writeData[14] = 0;
	writeData[15] = 0;
	writeData[16] = 0;
    writeData[17] = checkSum(writeData , 17);

    int32_t status = Uart_Write(uart_reference, writeData, 18);
    return status;

}


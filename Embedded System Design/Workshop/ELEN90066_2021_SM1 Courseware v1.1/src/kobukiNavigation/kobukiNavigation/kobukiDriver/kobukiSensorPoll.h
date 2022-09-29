/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	Methods to poll iRobot sensors.
				NOTE: Polling requires both transmitting and receiving
				to the UART port, hence these functions are *not*
				thread safe with regard to other UART functions.

	Revised:	2011-01-18
*/

#ifndef _IROBOT_SENSORPOLL_H
#define _IROBOT_SENSORPOLL_H

#include "kobukiUART.h"
#include "kobukiSensorTypes.h"
#include "kobukiSensor.h"

/* Request sensor packet from iRobot and wait for response */
extern int32_t kobukiSensorPoll(
	MyRio_Uart 	*	uart,				/* (in)		iRobot UART pot */
	KobukiSensors_t * const	sensors		/* (out)	Sensor group */
);

//uint32_t openUART(MyRio_Uart * uart);

#endif /* _IROBOT_SENSORPOLL_H  */

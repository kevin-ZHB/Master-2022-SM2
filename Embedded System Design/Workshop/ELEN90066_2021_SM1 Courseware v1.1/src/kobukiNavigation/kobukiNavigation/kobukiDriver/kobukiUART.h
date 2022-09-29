/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	UART wrappers for the iRobot Create. This library is not architecture
				specific, so these are only wrappers for UART functions that must
				be defined for your architecture.

	Revised:	2011-01-18
*/

#ifndef _KOBUKI_UART_H
#define _KOBUKI_UART_H


#include "../myrio/UART.h"


extern  int32_t kobukiReadFeedbackPacket(
		MyRio_Uart * uart,
		uint8_t * * packetBuffer
);

#endif

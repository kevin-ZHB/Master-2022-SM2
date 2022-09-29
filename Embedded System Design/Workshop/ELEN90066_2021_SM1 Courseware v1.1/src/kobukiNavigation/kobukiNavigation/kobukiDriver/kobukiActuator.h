/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	iRobot actuator commands.

	Revised:	2011-01-18
*/

#ifndef _KOBUKIACTUATOR_H
#define _KOBUKIACTUATOR_H

//#include "irobotError.h"
//#include "irobotOpcode.h"
//#include "irobotActuatorTypes.h"
#include "kobukiUART.h"

int32_t kobukiDriveDirect(
		MyRio_Uart * uart_reference,
		int16_t leftWheelSpeed,
		int16_t rightWheelSpeed
);


int32_t kobukiDriveRadius(
		MyRio_Uart * uart_reference,
		int16_t radius,
		int16_t speed
);


///* Write to the digital output bank of the cargo bay on iRobot. */
//extern int32_t irobotDigitalOutputs(
//	const irobotUARTPort_t	port,		/* (in)		UART port */
//	const uint8_t			output 		/* (in)		Pins  0-7 */
//);										/* (ret)	Error / success code */
//
///* Directly actuate left and right wheels. */
//extern int32_t irobotDriveDirect(
//	const irobotUARTPort_t	port,			/* (in)		UART port */
//	int16_t					leftWheelSpeed,	/* (in)		Left wheels speed, in mm/s */
//	int16_t					rightWheelSpeed /* (in)		Right wheel speed, in mm/s */
//);											/* (ret)	Error / success code */
//
///* Drives in a fixed direction  */
//extern int32_t irobotDriveDirection(
//	const irobotUARTPort_t		port,		/* (in)		UART port */
//	int16_t						velocity,	/* (in)		Velocity, in mm/s */
//	const irobotDirection_t		direction	/* (in)		direction */
//);											/* (ret)	Error / success code */
//
///* Drive the robot with a fixed linear speed, and turning through a fixed radius.
//  Do not call this function for the special cases of driving straight, or clockwise
//  and counter-clockwise turning; this function instructs the robot to drive only nonzero radii.  */
//extern int32_t irobotDriveRadius(
//	const irobotUARTPort_t	port,		/* (in)		UART port */
//	int16_t					velocity,	/* (in)		Velocity, in mm/s */
//	int16_t					radius		/* (in)		Radius, in mm */
//);										/* (ret)	Error / success code */
//
///* Change the state of the iRobot power, play, and advance LEDs. */
//extern int32_t irobotLEDs(
//	const irobotUARTPort_t	port,			/* (in)		UART port */
//	const irobotLED_t		leds,			/* (in)		LEDs to turn on */
//	const uint8_t			powerColor,		/* (in)		Power LED color (G[0] - R[255]) */
//	const uint8_t			powerIntensity	/* (in)		Power LED intensiy (0-255) */
//);											/* (ret)	Error / success code */
//
///* Set the PWM duty cycle of the low-side drivers. */
//extern int32_t irobotPWMLowSideDrivers(
//	const irobotUARTPort_t	port,		/* (in)		UART port */
//	uint8_t					pwm0,		/* (in)		PWM for low-side driver 0 (0-128 duty cycle) */
//	uint8_t					pwm1,		/* (in)		PWM for low-side driver 1 (0-128 duty cycle) */
//	uint8_t					pwm2		/* (in)		PWM for low-side driver 2 (0-128 duty cycle) */
//);										/* (ret)	Error / success code */
//
///*	Define a song. Each song is alloted 16 notes, but a song can "spill over" into
//	the next if so desired. The maximum number of notes that may be defined is
//	(16 - SongNumber) * 16. */
//extern int32_t irobotSong(
//	const irobotUARTPort_t			port,		/* (in)		UART port */
//	uint8_t							songNumber,	/* (in)		Song number */
//	const irobotSongNote_t * const	songNotes,	/* (in)		Song notes */
//	uint8_t							nNotes		/* (in)		Number of song notes */
//);												/* (ret)	Error / success code */
//
///* Play a song */
//extern int32_t irobotPlaySong(
//	const irobotUARTPort_t	port,		/* (in)		UART port */
//	const uint8_t			songNumber	/* (in)		Song number */
//);										/* (ret)	Error / success code */
//
///* Stops the wheels. */
//extern int32_t irobotStop(
//	const irobotUARTPort_t	port		/* (in)		UART port */
//);										/* (ret)	Error / success code */
//
//
//#endif	/* _IROBOTACTUATOR_H */

#endif /* _KOBUKIACTUATOR_H*/

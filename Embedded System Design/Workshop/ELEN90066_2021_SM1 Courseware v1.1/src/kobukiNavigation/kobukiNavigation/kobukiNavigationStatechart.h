/*
 * irobotNavigationStatechart.h
 *
 *  Created on: Mar 7, 2013
 *      Author: jjensen
 */

#ifndef IROBOTNAVIGATIONSTATECHART_H_
#define IROBOTNAVIGATIONSTATECHART_H_


#include "kobukiDriver/kobukiSensorTypes.h"
#include "myrio/Accelerometer.h"


/* accelerometer */


void KobukiNavigationStatechart(
	const int16_t 				maxWheelSpeed,						/* (in) maximum wheel speed, in mm/s */
	const int32_t 				netDistance,						/* (in) net distance, in mm */
	const int32_t 				netAngle,							/* (in) net angle, in deg */
	const KobukiSensors_t 	sensors,							/* (in) irobot sensors */
	const accelerometer_t 		accelAxes,								/* (in) filtered accelerometer, in g */
	int16_t * const 			pRightWheelSpeed,					/*(out) right wheel speed */
	int16_t * const 			pLeftWheelSpeed,					/*(out) left wheel speed */
	const bool					isSimulator							/* (in) statechart is executing within a simulator */
);

#endif /* IROBOTNAVIGATIONSTATECHART_H_ */

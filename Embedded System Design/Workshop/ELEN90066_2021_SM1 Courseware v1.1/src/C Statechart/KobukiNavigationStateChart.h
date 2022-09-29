#ifndef KOBUKINAVIGATIONSTATECHART_H_
#define KOBUKINAVIGATIONSTATECHART_H_

#define _USE_MATH_DEFINES
#include "KobukiSensorType.h"

/// Architecture-independent C Statechart.
void KobukiNavigationStatechart(
	const int16_t 				maxWheelSpeed,
	const int32_t 				netDistance,
	const int32_t 				netAngle,
	const KobukiSensors_t		sensors,
	const accelerometer_t			accelAxes,
	int16_t * const 			pRightWheelSpeed,
	int16_t * const 			pLeftWheelSpeed,
	const bool					isSimulator
	);

#endif // IROBOTNAVIGATIONSTATECHART_H_


#include <stdint.h>
#include "KobukiSensorType.h"
#include "KobukiSensors.h"
#include "KobukiNavigationStateChart.h"
#include <stdio.h>
const int16_t WHEEL_SPEED = 200;

int32_t LIBSTATECHARTEXAMPLE_EXP KobukiStatechartSimShell(
	const int32_t 			netDistance,
	const int32_t 			netAngle,
	const void* const       sensors,
	const int32_t			sensorStreamSize,
	const double * const	accelAxes,

	const int32_t			accelAxesSize,
	int16_t * const 		pRightWheelSpeed,
	int16_t * const 		pLeftWheelSpeed
	){
	accelerometer_t			accel;
	KobukiSensors_t			kobukisensors;
	int a = *((uint8_t*)sensors);
	ConvertToKobukiSensorData((uint8_t*)sensors, &kobukisensors);
	accel.x	=accelAxes[0];
	accel.y = accelAxes[1];
	accel.z = accelAxes[2];
	KobukiNavigationStatechart(
		WHEEL_SPEED,
		netDistance,
		netAngle,
		kobukisensors,
		accel,
		pRightWheelSpeed,
		pLeftWheelSpeed,
		true
		);
	return 0;  
}

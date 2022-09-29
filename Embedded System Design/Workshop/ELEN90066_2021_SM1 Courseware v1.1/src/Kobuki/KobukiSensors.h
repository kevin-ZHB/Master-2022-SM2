#ifndef __KOBUKISENSORS_H
#define __KOBUKISENSORS_H
#include "KobukiSensorType.h"
void ConvertToKobukiSensorData(uint8_t* RawSensorDataIn, KobukiSensors_t* SensorsOut);
#endif
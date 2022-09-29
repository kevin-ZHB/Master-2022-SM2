#include "KobukiSensors.h"
void ConvertToKobukiSensorData(uint8_t* RawSensorDataIn, KobukiSensors_t *SensorsOut)
{
    (*SensorsOut).bumps_wheelDrops.wheeldropLeft	= (bool)RawSensorDataIn[0];
	(*SensorsOut).bumps_wheelDrops.wheeldropRight	= (bool)RawSensorDataIn[1];
	(*SensorsOut).bumps_wheelDrops.bumpLeft			= (bool)RawSensorDataIn[2];
	(*SensorsOut).bumps_wheelDrops.bumpCenter		= (bool)RawSensorDataIn[3];
	(*SensorsOut).bumps_wheelDrops.bumpRight		= (bool)RawSensorDataIn[4];
	(*SensorsOut).cliffLeft							= (bool)RawSensorDataIn[5];
	(*SensorsOut).cliffCenter						= (bool)RawSensorDataIn[6];
	(*SensorsOut).cliffRight						= (bool)RawSensorDataIn[7];
	(*SensorsOut).cliffLeftSignal					= ((uint16_t)RawSensorDataIn[8])  | (((uint16_t)(RawSensorDataIn[9]))  << 8);
	(*SensorsOut).cliffCenterSignal					= ((uint16_t)RawSensorDataIn[10]) | (((uint16_t)(RawSensorDataIn[11])) << 8);
	(*SensorsOut).cliffRightSignal					= ((uint16_t)RawSensorDataIn[12]) | (((uint16_t)(RawSensorDataIn[13])) << 8);
	(*SensorsOut).buttons.B0						= (bool)RawSensorDataIn[14];
	(*SensorsOut).buttons.B1						= (bool)RawSensorDataIn[15];
	(*SensorsOut).buttons.B2						= (bool)RawSensorDataIn[16];
	(*SensorsOut).LeftWheelEncoder					= ((uint16_t)RawSensorDataIn[17]) | (((uint16_t)(RawSensorDataIn[18])) << 8);
	(*SensorsOut).RightWheelEncoder				= ((uint16_t)RawSensorDataIn[19]) | (((uint16_t)(RawSensorDataIn[20])) << 8);
	(*SensorsOut).LeftWheelPWM						= (uint8_t)RawSensorDataIn[21];
	(*SensorsOut).RightWheelPWM						= (uint8_t)RawSensorDataIn[22];
	(*SensorsOut).LeftWheelOverCurrent				= (bool)RawSensorDataIn[23];
	(*SensorsOut).RightWheelOverCurrent				= (bool)RawSensorDataIn[24];
	(*SensorsOut).LeftWheelCurrent					= (int16_t)(((uint16_t)RawSensorDataIn[25]) | (((uint16_t)(RawSensorDataIn[26])) << 8));
	(*SensorsOut).RightWheelCurrent					= (int16_t)(((uint16_t)RawSensorDataIn[27]) | (((uint16_t)(RawSensorDataIn[28])) << 8));
	(*SensorsOut).TimeStamp							= ((uint16_t)RawSensorDataIn[29]) | (((uint16_t)(RawSensorDataIn[30])) << 8);
}

/*	Project:	iRobot Create
	
	Author:		Jeff C. Jensen
				National Instruments
  
	Abstract:	Functions to read sensors from a data stream

	Revised:	2011-01-18
*/

#include "kobukiSensor.h"
#include <stdio.h>

void ConvertToKobukiSensorData(uint8_t* RawSensorDataIn, KobukiSensors_t *SensorsOut)// This function is used only in simulation to pass data from LabVIEW to DLL
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

uint16_t to_uint16( uint8_t d1, uint16_t d2){
	return ( (uint16_t) d2 << 8) | d1 ;
}

void kobukiParseSensorPacket(
	const uint8_t * packet,
	KobukiSensors_t * sensors
){

	uint8_t payloadLength = packet[2];
	uint8_t i = 3;
	uint8_t subPayloadLength = 0;


	while( i < payloadLength + 3) {

		uint8_t idField = packet[i];
		//determine identifier of datum
		int isError = 0;

		subPayloadLength = packet[i+1];

		switch(idField) {
			case 0x01 :
				//There's an ambiguity in the documentation where
				//it says there are two headers with value 0x01:
				// basic sensor data and controller info - although it
				// says elsewhere that controller info has ID 0x15
				// so we'll just check here to make sure it's the right length

				if( subPayloadLength == 0x0F){
					sensors->TimeStamp = to_uint16( packet[i+2], packet[i+3]);


					sensors->bumps_wheelDrops.bumpRight		=	packet[i+4] & 0x01;
					sensors->bumps_wheelDrops.bumpCenter	=	(packet[i+4] & 0x02);
					sensors->bumps_wheelDrops.bumpLeft		=	(packet[i+4] & 0x04);

					sensors->bumps_wheelDrops.wheeldropRight	= packet[i+5] & 0x01;
					sensors->bumps_wheelDrops.wheeldropLeft		=(packet[i+5] & 0x02);

					sensors->cliffRight		=	(packet[i+6] & 0x01);
					sensors->cliffCenter	=	(packet[i+6] & 0x02);
					sensors->cliffLeft		=	(packet[i+6] & 0x04);

					sensors->LeftWheelEncoder	= to_uint16(packet[i+7], packet[i+8]);
					sensors->RightWheelEncoder = to_uint16(packet[i+9], packet[i+10]);

					sensors->LeftWheelPWM		=	(int8_t) packet[i+11];
					sensors->RightWheelPWM 		=	(int8_t) packet[i+12];
					sensors->buttons.B0		=	(bool)(packet[i+13] & 0x01);
					sensors->buttons.B1		=	(bool)(packet[i+13] & 0x02);
					sensors->buttons.B2		=	(bool)(packet[i+13] & 0x04);

					// Charger state
					switch(packet[i+14]){
						case 0:
							sensors->chargingState = DISCHARGING;
							break;
						case 2:
							sensors->chargingState =  DOCKING_CHARGED;
							break;
						case 6:
							sensors->chargingState =  DOCKING_CHARGING;
							break;
						case 18:
							sensors->chargingState =  ADAPTER_CHARGED;
							break;
						case 22:
							sensors->chargingState =  ADAPTER_CHARGING;
							break;
					}

					sensors->LeftWheelOverCurrent = packet[i+15] & 0x01;
					sensors->RightWheelOverCurrent = packet[i+15] & 0x02;

					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}

				break;

			case 0x03 :
				// TODO Implement Docking IR. Documentation unclear
				if (subPayloadLength == 0x03){
					i += subPayloadLength + 2; // + 2 for header and length
					} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}

				break;

			case 0x04 : // inertial sensor data
				if (subPayloadLength == 0x07){
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x05 : // cliff sensor data
				if (subPayloadLength == 0x06){
					sensors->cliffRightSignal=to_uint16(packet[i+2],packet[i+3]);
					sensors->cliffCenterSignal=to_uint16(packet[i+4],packet[i+5]);
					sensors->cliffLeftSignal=to_uint16(packet[i+6],packet[i+7]);
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x06 :
				if (subPayloadLength == 0x02){
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x0A :
				if (subPayloadLength == 0x04){
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x0B : // Firmware Version
				if (subPayloadLength == 0x04){
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x0D : // Raw 3d Gyro DAta
				if (subPayloadLength % 6 == 2){ // variable length packet. See documentation
					i += subPayloadLength + 2; // + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x10 : //General purpose input
				if (subPayloadLength == 0x10){
					i += subPayloadLength + 2;	// + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x13 : // UID
				if (subPayloadLength == 0x0C){
					i += subPayloadLength + 2;	// + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

			case 0x15 :
				if (subPayloadLength == 0x15){
					i += subPayloadLength + 2;	// + 2 for header and length
				} else {
					isError = 1;
					i += payloadLength + 3; // add enough to terminate the outer while loop
				}
				break;

		}
	}

	//Checksum has already been checked.
	return;
}

void kobukiPrintSensors(
	const KobukiSensors_t sensors
){

	//TODO fill this in.
	printf("STUFF TO PRINT\n");
}

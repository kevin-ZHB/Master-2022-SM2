
#ifndef _KOBUKISENSORTYPES_H
#define _KOBUKISENSORTYPES_H
#include <stdint.h>
#ifdef LIBSTATECHARTEXAMPLE_EXPORTS
#define LIBSTATECHARTEXAMPLE_EXP	__declspec(dllexport) __cdecl
#else
#define LIBSTATECHARTEXAMPLE_EXP	__declspec(dllimport) __cdecl
#endif

#ifdef _MSC_VER
#ifndef __BOOL_DEFINED
typedef uint8_t bool;
#define true ( (bool)1 )
#define false ( (bool)0 )
#define __BOOL_DEFINED
#endif
#else
#include <stdbool.h>
#endif
/// accelerometer values
typedef struct{
	double	x;							///< x axis, in g
	double	y;							///< y axis, in g
	double	z;							///< z axis, in g
} accelerometer_t;

typedef struct{
	bool	wheeldropLeft;		///< State of the left wheeldrop sensor; when true, indicates the wheel is not in contact with the ground.
	bool	wheeldropRight;		///< State of the right wheeldrop sensor; when true, indicates the wheel is not in contact with the ground.
	bool	bumpLeft;			///< State of the left bump sensor; if true, the left side of the robot is in contact with an object.
	bool	bumpCenter;			///< State of the right bump sensor; if true, the right side of the robot is in contact with an object.
	bool	bumpRight;			///< State of the right bump sensor; if true, the right side of the robot is in contact with an object.
} KobukiBumps_WheelDrops_t;
/// Kobuki button sensors.
typedef struct{
	bool	B0;
	bool	B1;
	bool    B2;
} KobukiButtons_t;



typedef enum { DISCHARGING, DOCKING_CHARGED, DOCKING_CHARGING, ADAPTER_CHARGED, ADAPTER_CHARGING } chargerState_t;
typedef struct{
	///  bump and wheel-drop sensors.
	KobukiBumps_WheelDrops_t bumps_wheelDrops;
	/// Binary interpretation of the infrared wall sensor; if true, the sensor has read above a predefined threshold and indicates a wall (or object) is in	front of the robot.
	/// Binary interpretation of the left cliff sensor; if true, the sensor has read below a predefined threshold and indicates the sensor is not immediately above ground.
	bool cliffLeft;
	/// Binary interpretation of the front left cliff sensor; if true, the sensor has read below a predefined threshold and indicates the sensor is not immediately above ground.
	bool cliffCenter;
	/// Binary interpretation of the right cliff sensor; if true, the sensor has read below a predefined threshold and indicates the sensor is not immediately above ground.
	bool cliffRight;
	uint16_t	cliffLeftSignal;		///< Sampled value of the analog left cliff sensor, range 0-4095.
	uint16_t	cliffCenterSignal;	///< Sampled value of the analog front left cliff sensor, range 0-4095.
	uint16_t	cliffRightSignal;		///< Sampled value of the analog right cliff sensor, range 0-4095.

	/// Kobuki button sensors.
	KobukiButtons_t buttons;
	///Motor related values
	uint16_t	LeftWheelEncoder;
	uint16_t	RightWheelEncoder;
	int16_t		LeftWheelCurrent;
	int16_t		RightWheelCurrent;
	int8_t		LeftWheelPWM;
	int8_t		RightWheelPWM;
	bool		LeftWheelOverCurrent;
	bool		RightWheelOverCurrent;
	//TimeStampe
	uint16_t	TimeStamp;
	//Battery related values
	uint8_t		BatteryVoltage;
	chargerState_t chargingState;
	//Inertia measurement : calibrated angle of rotation around Z-axis
	int16_t Angle;
	int16_t AngleRate;
} KobukiSensors_t;
#endif

/* FIXME: Verify correct myRIO macros are set in project settings */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <unistd.h>
#include <sys/time.h>
#include <inttypes.h>

#include "myrio/UART.h"
#include "myrio/visa.h"
#include "kobukiDriver/kobukiSensorPoll.h"
#include "kobukiDriver/kobukiActuator.h"

#include "myrio/MyRio.h"
#include "myrio/Accelerometer.h"
#include "kobukiNavigationStatechart.h"
//#include "DIO.h"
#define BaudRate 115200
#define DataBit 8

/* Function prototypes */
uint64_t getTimeInMs(void);
void delayMs(const uint64_t msDelay);
void waitUntilNextMsMultiple(const uint64_t msMultiple);
int32_t openUART(MyRio_Uart * uart);
extern NiFpga_Session myrio_session; // this is global session . It is useful to do low level hardware.
/* IO settings */


/* program parameters */
const int32_t driveDistance = 200;		/* distance to drive, in mm */
const int32_t turnAngle = 90;			/* angle to turn, in mm */
const int16_t WHEEL_SPEED = 200;		/* maximum speed to turn the wheels, in mm/s */
const double  accelSmoothing = 0.1;		/* accelerometer smoothing coefficient */
int32_t normalized180(int32_t a){
    a = (a + 180)%360;
    if (a < 0)
        a += 360;
    return a - 180;
}
int main(int argc, char **argv){
	NiFpga_Status status = 0;

	int32_t drive_status = 0;
	int32_t sensor_status = 0;

	MyRio_Uart uart;
    uart.name = "ASRL2::INSTR";
    uart.defaultRM = 0;
    uart.session = 0;
	status = openUART(&uart);
	Uart_Clear(&uart);


	/* Hardware peripherals */
	 MyRio_Accl				accelDevice;

	/* sensor inputs */
	KobukiSensors_t			sensors;				/* kobuki sensors */
	int32_t  			    netDistance = 0;			/* net distance the robot has traveled, in mm */
	double				netAngle= 0;				/* net angle through which the robot has turned, in deg */
	accelerometer_t			accelValue = {0.0,0.0,0.0};	/* accelerometer, in g */

	/* actuator outputs */
	int16_t					leftWheelSpeed = 0;		/* speed of the left wheel, in mm/s */
	int16_t					rightWheelSpeed = 0;	/* speed of the right wheel, in mm/s */

	accelDevice.xval = ACCXVAL;
	accelDevice.yval = ACCYVAL;
	accelDevice.zval = ACCZVAL;
	accelDevice.scale_wght = ACCSCALEWGHT_CST;

	Accel_Scaling(&accelDevice);


	/*
	 * Open the myRIO NiFpga Session.
	 * This function MUST be called before all other functions. After this call
	 * is complete the myRIO target will be ready to be used.
	 */
	status = MyRio_Open();

	accelerometer_t accelValue0;
	double accL=0;//accumulative distance travel of the left wheel
	double accR=0;//accumulative distance travel of the right wheel
	double distanceAccL=0;
	double distanceAccR=0;
	uint16_t prevL=sensors.LeftWheelEncoder; //store value of previous reading of left wheel encoder
	uint16_t prevR=sensors.RightWheelEncoder;//store value of previous reading of right wheel encoder
	int firstRun=1; //flag to indicate this is the firstRun this will be used to do integrating left and right wheel encoder.
	while(!NiFpga_IsError(status)){
		sensor_status = kobukiSensorPoll(&uart, &sensors);
				if(sensor_status < VI_SUCCESS ){
					printf("kobukiSensorPoll failed with sensor_status: %d\n", sensor_status );
				}
				if (firstRun){
					prevL=sensors.LeftWheelEncoder;
					prevR=sensors.RightWheelEncoder;
					firstRun=0;
				}
				distanceAccL+=abs((int16_t)(sensors.LeftWheelEncoder-prevL));
				distanceAccR+=abs((int16_t)(sensors.RightWheelEncoder-prevR));
				accL += ((int16_t)(sensors.LeftWheelEncoder-prevL)); //casting the difference to int16 mimic the clock arithmetic on each wheel encoder
				accR += ((int16_t)(sensors.RightWheelEncoder-prevR));//casting the difference to int16 mimic the clock arithmetic on each wheel encoder
				prevL=sensors.LeftWheelEncoder;
				prevR=sensors.RightWheelEncoder;
				//netDistance = (accL+ accR) * .08532 /2.0;
				netDistance = (distanceAccL+ distanceAccR) * .08532 /2.0;
				netAngle    = normalized180(((accR - accL) * .021255)); //Normilized netangle to -180 to 180
				/* Read and filter accelerometer */
				accelValue0 = accelValue;

				accelValue.x = Accel_ReadX(&accelDevice);
				accelValue.y = Accel_ReadY(&accelDevice);
				accelValue.z = Accel_ReadZ(&accelDevice);

				/* exponential lowpass filter */
				accelValue.x = accelSmoothing * accelValue.x + (1 - accelSmoothing) * accelValue0.x;
				accelValue.y = accelSmoothing * accelValue.y + (1 - accelSmoothing) * accelValue0.y;
				accelValue.z = accelSmoothing * accelValue.z + (1 - accelSmoothing) * accelValue0.z;


				// TODO : ADD KEEP ALIVE INSTRUCTION

				//accelValue.x = accelValue.y = accelValue.z = 0.0;

				/* Execute statechart */
				KobukiNavigationStatechart(WHEEL_SPEED,netDistance,netAngle,sensors,accelValue,&rightWheelSpeed,&leftWheelSpeed,false);

				drive_status = kobukiDriveDirect(&uart, leftWheelSpeed, rightWheelSpeed);

				if (drive_status < VI_SUCCESS){
				//	printf("Drive command failed with status %d\n", drive_status);
					return -1;
				}
				// This is example how to turn on LED0 . DOLED30 is the address of the LED[0-3] lowest bit is LED0
				//LED can be usefull to debug when there's no other communication method .
				NiFpga_WriteU8 (myrio_session , DOLED30 , 0x01);

				//Wait until 80ms pass
				waitUntilNextMsMultiple(80);


	}

	return status;
}

/* system time, in ms */
uint64_t getTimeInMs(void){
	struct timeval tv;
	gettimeofday(&tv, NULL);
	return (tv.tv_sec) * 1000 + (tv.tv_usec) / 1000;
}

/* delay a fixed number of ms */
void delayMs(const uint64_t msDelay){
	usleep(msDelay * 1000);
}

/* loop timing - wait until system clock is modulo ms */
void waitUntilNextMsMultiple(const uint64_t msMultiple){
	const uint64_t msCounter = getTimeInMs() % msMultiple;
	if(msCounter > 0){
		delayMs(msMultiple - msCounter);	/* delay modulo difference */
	}
}


int32_t openUART(MyRio_Uart * p_uart){
    int32_t status = 0;
	status = Uart_Open(p_uart, BaudRate, DataBit,
                       Uart_StopBits1_0, Uart_ParityNone);
    if (status < VI_SUCCESS)
    {
    	printf("Open failed\n");
    }
    return status;
}

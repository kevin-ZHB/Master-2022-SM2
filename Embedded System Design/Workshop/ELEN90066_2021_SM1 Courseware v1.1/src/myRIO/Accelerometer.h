/*
 * Accelerometer.h
 *
 * Copyright (c) 2013,
 * National Instruments Corporation.
 * All rights reserved.
 */

#ifndef Accelerometer_h_
#define Accelerometer_h_

#include "MyRio.h"

#if NiFpga_Cpp
extern "C" {
#endif


/**
 * Registers and settings for the accelerometer
 */
typedef struct
{
    uint32_t xval;          /**< Accelerometer X value register */
    uint32_t yval;          /**< Accelerometer Y value register */
    uint32_t zval;          /**< Accelerometer Z value register */
    uint32_t scale_wght;    /**< Accelerometer weight register */
    double   scale;         /**< Accelerometer weight value */
} MyRio_Accl;


/**
 * Read the value in the X direction.
 */
double Accel_ReadX(MyRio_Accl* channel);


/**
 * Read the value in the Y direction.
 */
double Accel_ReadY(MyRio_Accl* channel);


/**
 * Read the value in the Z direction.
 */
double Accel_ReadZ(MyRio_Accl* channel);


/**
 * Get the scaling weight for the accelerometer.
 */
void Accel_Scaling(MyRio_Accl* channel);

#if NiFpga_Cpp
}
#endif

#endif /* Accelerometer_h_ */

/*
 * myRIO 1900 Target Header File
 *
 * Definitions for myRIO 1900
 * This file should be included from "MyRio.h", never directly
 *
 * Copyright (c) 2013,
 * National Instruments Corporation.
 * All rights reserved.
 */

#ifndef MyRio1900_h_
#define MyRio1900_h_

/* Guard against direct include */
#ifndef MyRio_h_
#    error "Include MyRio.h instead of MyRio1900.h"
#endif


/* Guard against including multiple myRIO target header files. */
#ifndef MyRioXXXX
#   define MyRioXXXX "MyRio1900.h"
#else
#    error "Attempt to include more that one MyRioXXXX.h file."
#endif


/*
 * Include NiFpga header files
 */
#include "NiFpga.h"
#include "NiFpga_MyRio1900Fpga10.h"


/*
 * Set the Bitfile and the Signtature
 */
#define MyRio_Bitfile	NiFpga_MyRio1900Fpga10_Bitfile
#define MyRio_Signature NiFpga_MyRio1900Fpga10_Signature


/**
 * Redefinition of the NiFpga Bool Indicator enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadBool and NiFpga_WriteBool functions should be used to access these
 * items.
 */
typedef enum
{
    AOSYSSTAT = NiFpga_MyRio1900Fpga10_IndicatorBool_AOSYSSTAT,
    SYSACCRDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSACCRDY,
    SYSACC_SCALERDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSACC_SCALERDY,
    SYSAIRDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAIRDY,
    SYSAI_SCALERDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAI_SCALERDY,
    SYSAO_SCALERDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAO_SCALERDY,
    SYSRDY = NiFpga_MyRio1900Fpga10_IndicatorBool_SYSRDY,
} MyRio1900Fpga10_IndicatorBool;


/**
 * Redefinition of the NiFpga U8 Indicator enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadU8 and NiFpga_WriteU8 functions should be used to access these
 * items.
 */
typedef enum
{
    DIBTN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIBTN,
    DIOA_158IN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIOA_158IN,
    DIOA_70IN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIOA_70IN,
    DIOB_158IN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIOB_158IN,
    DIOB_70IN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIOB_70IN,
    DIOC_70IN = NiFpga_MyRio1900Fpga10_IndicatorU8_DIOC_70IN,
    ENCASTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_ENCASTAT,
    ENCBSTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_ENCBSTAT,
    ENCC_0STAT = NiFpga_MyRio1900Fpga10_IndicatorU8_ENCC_0STAT,
    ENCC_1STAT = NiFpga_MyRio1900Fpga10_IndicatorU8_ENCC_1STAT,
    I2CADATI = NiFpga_MyRio1900Fpga10_IndicatorU8_I2CADATI,
    I2CASTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_I2CASTAT,
    I2CBDATI = NiFpga_MyRio1900Fpga10_IndicatorU8_I2CBDATI,
    I2CBSTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_I2CBSTAT,
    SPIASTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_SPIASTAT,
    SPIBSTAT = NiFpga_MyRio1900Fpga10_IndicatorU8_SPIBSTAT,
} MyRio1900Fpga10_IndicatorU8;


/**
 * Redefinition of the NiFpga U16 Indicator enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadU16 and NiFpga_WriteU16 functions should be used to access these
 * items.
 */
typedef enum
{
    ACCSCALEWGHT = NiFpga_MyRio1900Fpga10_IndicatorU16_ACCSCALEWGHT,
    ACCXVAL = NiFpga_MyRio1900Fpga10_IndicatorU16_ACCXVAL,
    ACCYVAL = NiFpga_MyRio1900Fpga10_IndicatorU16_ACCYVAL,
    ACCZVAL = NiFpga_MyRio1900Fpga10_IndicatorU16_ACCZVAL,
    AIA_0VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_0VAL,
    AIA_1VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_1VAL,
    AIA_2VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_2VAL,
    AIA_3VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_3VAL,
    AIAudioIn_LVAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIAudioIn_LVAL,
    AIAudioIn_RVAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIAudioIn_RVAL,
    AIB_0VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_0VAL,
    AIB_1VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_1VAL,
    AIB_2VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_2VAL,
    AIB_3VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_3VAL,
    AIC_0VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIC_0VAL,
    AIC_1VAL = NiFpga_MyRio1900Fpga10_IndicatorU16_AIC_1VAL,
    PWMA_0CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_0CNTR,
    PWMA_1CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_1CNTR,
    PWMA_2CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_2CNTR,
    PWMB_0CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_0CNTR,
    PWMB_1CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_1CNTR,
    PWMB_2CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_2CNTR,
    PWMC_0CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMC_0CNTR,
    PWMC_1CNTR = NiFpga_MyRio1900Fpga10_IndicatorU16_PWMC_1CNTR,
    SPIADATI = NiFpga_MyRio1900Fpga10_IndicatorU16_SPIADATI,
    SPIBDATI = NiFpga_MyRio1900Fpga10_IndicatorU16_SPIBDATI,
} MyRio1900Fpga10_IndicatorU16;


/**
 * Redefinition of the NiFpga U32 Indicator enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadU32 and NiFpga_WriteU32 functions should be used to access these
 * items.
 */
typedef enum
{
    AIA_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_0OFST,
    AIA_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_0WGHT,
    AIA_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_1OFST,
    AIA_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_1WGHT,
    AIA_2OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_2OFST,
    AIA_2WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_2WGHT,
    AIA_3OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_3OFST,
    AIA_3WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_3WGHT,
    AIAudioIn_LOFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_LOFST,
    AIAudioIn_LWGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_LWGHT,
    AIAudioIn_ROFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_ROFST,
    AIAudioIn_RWGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_RWGHT,
    AIB_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_0OFST,
    AIB_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_0WGHT,
    AIB_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_1OFST,
    AIB_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_1WGHT,
    AIB_2OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_2OFST,
    AIB_2WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_2WGHT,
    AIB_3OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_3OFST,
    AIB_3WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_3WGHT,
    AIC_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_0OFST,
    AIC_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_0WGHT,
    AIC_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_1OFST,
    AIC_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_1WGHT,
    AOA_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_0OFST,
    AOA_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_0WGHT,
    AOA_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_1OFST,
    AOA_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_1WGHT,
    AOAudioOut_LOFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_LOFST,
    AOAudioOut_LWGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_LWGHT,
    AOAudioOut_ROFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_ROFST,
    AOAudioOut_RWGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_RWGHT,
    AOB_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_0OFST,
    AOB_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_0WGHT,
    AOB_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_1OFST,
    AOB_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_1WGHT,
    AOC_0OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_0OFST,
    AOC_0WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_0WGHT,
    AOC_1OFST = NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_1OFST,
    AOC_1WGHT = NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_1WGHT,
    ENCACNTR = NiFpga_MyRio1900Fpga10_IndicatorU32_ENCACNTR,
    ENCBCNTR = NiFpga_MyRio1900Fpga10_IndicatorU32_ENCBCNTR,
    ENCC_0CNTR = NiFpga_MyRio1900Fpga10_IndicatorU32_ENCC_0CNTR,
    ENCC_1CNTR = NiFpga_MyRio1900Fpga10_IndicatorU32_ENCC_1CNTR,
} MyRio1900Fpga10_IndicatorU32;


/**
 * Redefinition of the NiFpga Bool Control enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadBool and NiFpga_WriteBool functions should be used to access these
 * items.
 */
typedef enum
{
    AOSYSGO = NiFpga_MyRio1900Fpga10_ControlBool_AOSYSGO,
    I2CAGO = NiFpga_MyRio1900Fpga10_ControlBool_I2CAGO,
    I2CBGO = NiFpga_MyRio1900Fpga10_ControlBool_I2CBGO,
    SPIAGO = NiFpga_MyRio1900Fpga10_ControlBool_SPIAGO,
    SPIBGO = NiFpga_MyRio1900Fpga10_ControlBool_SPIBGO,
} MyRio1900Fpga10_ControlBool;


/**
 * Redefinition of the NiFpga U8 Control enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadU8 and NiFpga_WriteU8 functions should be used to access these
 * items.
 */
typedef enum
{
    DIOA_158DIR = NiFpga_MyRio1900Fpga10_ControlU8_DIOA_158DIR,
    DIOA_158OUT = NiFpga_MyRio1900Fpga10_ControlU8_DIOA_158OUT,
    DIOA_70DIR = NiFpga_MyRio1900Fpga10_ControlU8_DIOA_70DIR,
    DIOA_70OUT = NiFpga_MyRio1900Fpga10_ControlU8_DIOA_70OUT,
    DIOB_158DIR = NiFpga_MyRio1900Fpga10_ControlU8_DIOB_158DIR,
    DIOB_158OUT = NiFpga_MyRio1900Fpga10_ControlU8_DIOB_158OUT,
    DIOB_70DIR = NiFpga_MyRio1900Fpga10_ControlU8_DIOB_70DIR,
    DIOB_70OUT = NiFpga_MyRio1900Fpga10_ControlU8_DIOB_70OUT,
    DIOC_70DIR = NiFpga_MyRio1900Fpga10_ControlU8_DIOC_70DIR,
    DIOC_70OUT = NiFpga_MyRio1900Fpga10_ControlU8_DIOC_70OUT,
    DOLED30 = NiFpga_MyRio1900Fpga10_ControlU8_DOLED30,
    ENCACNFG = NiFpga_MyRio1900Fpga10_ControlU8_ENCACNFG,
    ENCBCNFG = NiFpga_MyRio1900Fpga10_ControlU8_ENCBCNFG,
    ENCC_0CNFG = NiFpga_MyRio1900Fpga10_ControlU8_ENCC_0CNFG,
    ENCC_1CNFG = NiFpga_MyRio1900Fpga10_ControlU8_ENCC_1CNFG,
    I2CAADDR = NiFpga_MyRio1900Fpga10_ControlU8_I2CAADDR,
    I2CACNFG = NiFpga_MyRio1900Fpga10_ControlU8_I2CACNFG,
    I2CACNTL = NiFpga_MyRio1900Fpga10_ControlU8_I2CACNTL,
    I2CACNTR = NiFpga_MyRio1900Fpga10_ControlU8_I2CACNTR,
    I2CADATO = NiFpga_MyRio1900Fpga10_ControlU8_I2CADATO,
    I2CBADDR = NiFpga_MyRio1900Fpga10_ControlU8_I2CBADDR,
    I2CBCNFG = NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNFG,
    I2CBCNTL = NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNTL,
    I2CBCNTR = NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNTR,
    I2CBDATO = NiFpga_MyRio1900Fpga10_ControlU8_I2CBDATO,
    PWMA_0CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_0CNFG,
    PWMA_0CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_0CS,
    PWMA_1CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_1CNFG,
    PWMA_1CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_1CS,
    PWMA_2CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_2CNFG,
    PWMA_2CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMA_2CS,
    PWMB_0CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_0CNFG,
    PWMB_0CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_0CS,
    PWMB_1CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_1CNFG,
    PWMB_1CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_1CS,
    PWMB_2CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_2CNFG,
    PWMB_2CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMB_2CS,
    PWMC_0CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMC_0CNFG,
    PWMC_0CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMC_0CS,
    PWMC_1CNFG = NiFpga_MyRio1900Fpga10_ControlU8_PWMC_1CNFG,
    PWMC_1CS = NiFpga_MyRio1900Fpga10_ControlU8_PWMC_1CS,
    SYSSELECTA = NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTA,
    SYSSELECTB = NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTB,
    SYSSELECTC = NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTC,
} MyRio1900Fpga10_ControlU8;


/**
 * Redefinition of the NiFpga U16 Control enum.
 * This is provided as a convenience to shorten the default enum names. The
 * NiFpga_ReadU16 and NiFpga_WriteU16 functions should be used to access these
 * items.
 */
typedef enum
{
    AOA_0VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOA_0VAL,
    AOA_1VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOA_1VAL,
    AOAudioOut_LVAL = NiFpga_MyRio1900Fpga10_ControlU16_AOAudioOut_LVAL,
    AOAudioOut_RVAL = NiFpga_MyRio1900Fpga10_ControlU16_AOAudioOut_RVAL,
    AOB_0VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOB_0VAL,
    AOB_1VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOB_1VAL,
    AOC_0VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOC_0VAL,
    AOC_1VAL = NiFpga_MyRio1900Fpga10_ControlU16_AOC_1VAL,
    PWMA_0CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_0CMP,
    PWMA_0MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_0MAX,
    PWMA_1CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_1CMP,
    PWMA_1MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_1MAX,
    PWMA_2CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_2CMP,
    PWMA_2MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMA_2MAX,
    PWMB_0CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_0CMP,
    PWMB_0MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_0MAX,
    PWMB_1CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_1CMP,
    PWMB_1MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_1MAX,
    PWMB_2CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_2CMP,
    PWMB_2MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMB_2MAX,
    PWMC_0CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMC_0CMP,
    PWMC_0MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMC_0MAX,
    PWMC_1CMP = NiFpga_MyRio1900Fpga10_ControlU16_PWMC_1CMP,
    PWMC_1MAX = NiFpga_MyRio1900Fpga10_ControlU16_PWMC_1MAX,
    SPIACNFG = NiFpga_MyRio1900Fpga10_ControlU16_SPIACNFG,
    SPIACNT = NiFpga_MyRio1900Fpga10_ControlU16_SPIACNT,
    SPIADATO = NiFpga_MyRio1900Fpga10_ControlU16_SPIADATO,
    SPIBCNFG = NiFpga_MyRio1900Fpga10_ControlU16_SPIBCNFG,
    SPIBCNT = NiFpga_MyRio1900Fpga10_ControlU16_SPIBCNT,
    SPIBDATO = NiFpga_MyRio1900Fpga10_ControlU16_SPIBDATO,
} MyRio1900Fpga10_ControlU16;


#endif /* MyRio1900_h_ */

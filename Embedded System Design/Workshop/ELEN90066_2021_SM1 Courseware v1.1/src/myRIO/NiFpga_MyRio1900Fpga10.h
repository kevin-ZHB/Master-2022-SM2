/*
 * Generated with the FPGA Interface C API Generator 13.0.0
 * for NI-RIO 13.0.0 or later.
 */

#ifndef __NiFpga_MyRio1900Fpga10_h__
#define __NiFpga_MyRio1900Fpga10_h__

#ifndef NiFpga_Version
   #define NiFpga_Version 1300
#endif

#include "NiFpga.h"

/**
 * The filename of the FPGA bitfile.
 *
 * This is a #define to allow for string literal concatenation. For example:
 *
 *    static const char* const Bitfile = "C:\\" NiFpga_MyRio1900Fpga10_Bitfile;
 */
#define NiFpga_MyRio1900Fpga10_Bitfile "NiFpga_MyRio1900Fpga10.lvbitx"

/**
 * The signature of the FPGA bitfile.
 */
static const char* const NiFpga_MyRio1900Fpga10_Signature = "09ECCCC4A969C0ABE1AFCC8BE18E05DB";

typedef enum
{
   NiFpga_MyRio1900Fpga10_IndicatorBool_AOSYSSTAT = 0x1800E,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSACCRDY = 0x180C6,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSACC_SCALERDY = 0x1800A,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAIRDY = 0x181AE,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAI_SCALERDY = 0x1805A,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSAO_SCALERDY = 0x18056,
   NiFpga_MyRio1900Fpga10_IndicatorBool_SYSRDY = 0x181AA,
} NiFpga_MyRio1900Fpga10_IndicatorBool;

typedef enum
{
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIBTN = 0x180BA,
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIOA_158IN = 0x180FA,
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIOA_70IN = 0x1816A,
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIOB_158IN = 0x180EE,
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIOB_70IN = 0x1827E,
   NiFpga_MyRio1900Fpga10_IndicatorU8_DIOC_70IN = 0x1815E,
   NiFpga_MyRio1900Fpga10_IndicatorU8_ENCASTAT = 0x18206,
   NiFpga_MyRio1900Fpga10_IndicatorU8_ENCBSTAT = 0x18202,
   NiFpga_MyRio1900Fpga10_IndicatorU8_ENCC_0STAT = 0x18132,
   NiFpga_MyRio1900Fpga10_IndicatorU8_ENCC_1STAT = 0x18126,
   NiFpga_MyRio1900Fpga10_IndicatorU8_I2CADATI = 0x181C6,
   NiFpga_MyRio1900Fpga10_IndicatorU8_I2CASTAT = 0x181E6,
   NiFpga_MyRio1900Fpga10_IndicatorU8_I2CBDATI = 0x181D6,
   NiFpga_MyRio1900Fpga10_IndicatorU8_I2CBSTAT = 0x181EE,
   NiFpga_MyRio1900Fpga10_IndicatorU8_SPIASTAT = 0x181FA,
   NiFpga_MyRio1900Fpga10_IndicatorU8_SPIBSTAT = 0x181F2,
} NiFpga_MyRio1900Fpga10_IndicatorU8;

typedef enum
{
   NiFpga_MyRio1900Fpga10_IndicatorU16_ACCSCALEWGHT = 0x18006,
   NiFpga_MyRio1900Fpga10_IndicatorU16_ACCXVAL = 0x180CE,
   NiFpga_MyRio1900Fpga10_IndicatorU16_ACCYVAL = 0x180CA,
   NiFpga_MyRio1900Fpga10_IndicatorU16_ACCZVAL = 0x180C2,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_0VAL = 0x18282,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_1VAL = 0x18286,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_2VAL = 0x1828A,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIA_3VAL = 0x1828E,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIAudioIn_LVAL = 0x180DE,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIAudioIn_RVAL = 0x180E2,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_0VAL = 0x18292,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_1VAL = 0x18296,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_2VAL = 0x1829A,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIB_3VAL = 0x1829E,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIC_0VAL = 0x18152,
   NiFpga_MyRio1900Fpga10_IndicatorU16_AIC_1VAL = 0x18156,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_0CNTR = 0x18242,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_1CNTR = 0x18256,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMA_2CNTR = 0x1826A,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_0CNTR = 0x18176,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_1CNTR = 0x1818A,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMB_2CNTR = 0x1819E,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMC_0CNTR = 0x18106,
   NiFpga_MyRio1900Fpga10_IndicatorU16_PWMC_1CNTR = 0x1811A,
   NiFpga_MyRio1900Fpga10_IndicatorU16_SPIADATI = 0x18232,
   NiFpga_MyRio1900Fpga10_IndicatorU16_SPIBDATI = 0x1821E,
} NiFpga_MyRio1900Fpga10_IndicatorU16;

typedef enum
{
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_0OFST = 0x18088,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_0WGHT = 0x180B4,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_1OFST = 0x1805C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_1WGHT = 0x180B0,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_2OFST = 0x18060,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_2WGHT = 0x180AC,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_3OFST = 0x18064,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIA_3WGHT = 0x180A8,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_LOFST = 0x18080,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_LWGHT = 0x18090,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_ROFST = 0x18084,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIAudioIn_RWGHT = 0x1808C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_0OFST = 0x18068,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_0WGHT = 0x180A4,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_1OFST = 0x1806C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_1WGHT = 0x18010,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_2OFST = 0x18070,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_2WGHT = 0x180A0,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_3OFST = 0x18074,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIB_3WGHT = 0x1809C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_0OFST = 0x18078,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_0WGHT = 0x18098,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_1OFST = 0x1807C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AIC_1WGHT = 0x18094,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_0OFST = 0x1803C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_0WGHT = 0x18024,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_1OFST = 0x18050,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOA_1WGHT = 0x18028,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_LOFST = 0x18048,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_LWGHT = 0x18034,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_ROFST = 0x1804C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOAudioOut_RWGHT = 0x18038,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_0OFST = 0x1801C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_0WGHT = 0x18014,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_1OFST = 0x18020,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOB_1WGHT = 0x18018,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_0OFST = 0x18040,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_0WGHT = 0x1802C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_1OFST = 0x18044,
   NiFpga_MyRio1900Fpga10_IndicatorU32_AOC_1WGHT = 0x18030,
   NiFpga_MyRio1900Fpga10_IndicatorU32_ENCACNTR = 0x1820C,
   NiFpga_MyRio1900Fpga10_IndicatorU32_ENCBCNTR = 0x18208,
   NiFpga_MyRio1900Fpga10_IndicatorU32_ENCC_0CNTR = 0x18134,
   NiFpga_MyRio1900Fpga10_IndicatorU32_ENCC_1CNTR = 0x18128,
} NiFpga_MyRio1900Fpga10_IndicatorU32;

typedef enum
{
   NiFpga_MyRio1900Fpga10_ControlBool_AOSYSGO = 0x180D2,
   NiFpga_MyRio1900Fpga10_ControlBool_I2CAGO = 0x181B6,
   NiFpga_MyRio1900Fpga10_ControlBool_I2CBGO = 0x181B2,
   NiFpga_MyRio1900Fpga10_ControlBool_SPIAGO = 0x181FE,
   NiFpga_MyRio1900Fpga10_ControlBool_SPIBGO = 0x181F6,
} NiFpga_MyRio1900Fpga10_ControlBool;

typedef enum
{
   NiFpga_MyRio1900Fpga10_ControlU8_DIOA_158DIR = 0x180F2,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOA_158OUT = 0x180F6,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOA_70DIR = 0x18162,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOA_70OUT = 0x18166,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOB_158DIR = 0x180EA,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOB_158OUT = 0x180E6,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOB_70DIR = 0x1827A,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOB_70OUT = 0x18276,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOC_70DIR = 0x18002,
   NiFpga_MyRio1900Fpga10_ControlU8_DIOC_70OUT = 0x1815A,
   NiFpga_MyRio1900Fpga10_ControlU8_DOLED30 = 0x180BE,
   NiFpga_MyRio1900Fpga10_ControlU8_ENCACNFG = 0x18216,
   NiFpga_MyRio1900Fpga10_ControlU8_ENCBCNFG = 0x18212,
   NiFpga_MyRio1900Fpga10_ControlU8_ENCC_0CNFG = 0x1813A,
   NiFpga_MyRio1900Fpga10_ControlU8_ENCC_1CNFG = 0x1812E,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CAADDR = 0x181CA,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CACNFG = 0x181BA,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CACNTL = 0x181E2,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CACNTR = 0x181CE,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CADATO = 0x181C2,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CBADDR = 0x181DA,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNFG = 0x181BE,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNTL = 0x181EA,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CBCNTR = 0x181DE,
   NiFpga_MyRio1900Fpga10_ControlU8_I2CBDATO = 0x181D2,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_0CNFG = 0x18246,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_0CS = 0x1824A,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_1CNFG = 0x1825A,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_1CS = 0x1825E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_2CNFG = 0x1826E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMA_2CS = 0x18272,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_0CNFG = 0x1817A,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_0CS = 0x1817E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_1CNFG = 0x1818E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_1CS = 0x18192,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_2CNFG = 0x181A2,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMB_2CS = 0x181A6,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMC_0CNFG = 0x1810A,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMC_0CS = 0x1810E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMC_1CNFG = 0x1811E,
   NiFpga_MyRio1900Fpga10_ControlU8_PWMC_1CS = 0x18122,
   NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTA = 0x1813E,
   NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTB = 0x18146,
   NiFpga_MyRio1900Fpga10_ControlU8_SYSSELECTC = 0x18142,
} NiFpga_MyRio1900Fpga10_ControlU8;

typedef enum
{
   NiFpga_MyRio1900Fpga10_ControlU16_AOA_0VAL = 0x182AE,
   NiFpga_MyRio1900Fpga10_ControlU16_AOA_1VAL = 0x182AA,
   NiFpga_MyRio1900Fpga10_ControlU16_AOAudioOut_LVAL = 0x180D6,
   NiFpga_MyRio1900Fpga10_ControlU16_AOAudioOut_RVAL = 0x180DA,
   NiFpga_MyRio1900Fpga10_ControlU16_AOB_0VAL = 0x182A6,
   NiFpga_MyRio1900Fpga10_ControlU16_AOB_1VAL = 0x182A2,
   NiFpga_MyRio1900Fpga10_ControlU16_AOC_0VAL = 0x1814E,
   NiFpga_MyRio1900Fpga10_ControlU16_AOC_1VAL = 0x1814A,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_0CMP = 0x1823E,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_0MAX = 0x1823A,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_1CMP = 0x1824E,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_1MAX = 0x18252,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_2CMP = 0x18262,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMA_2MAX = 0x18266,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_0CMP = 0x1816E,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_0MAX = 0x18172,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_1CMP = 0x18182,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_1MAX = 0x18186,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_2CMP = 0x18196,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMB_2MAX = 0x1819A,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMC_0CMP = 0x18102,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMC_0MAX = 0x180FE,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMC_1CMP = 0x18116,
   NiFpga_MyRio1900Fpga10_ControlU16_PWMC_1MAX = 0x18112,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIACNFG = 0x1822E,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIACNT = 0x1822A,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIADATO = 0x18236,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIBCNFG = 0x18222,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIBCNT = 0x18226,
   NiFpga_MyRio1900Fpga10_ControlU16_SPIBDATO = 0x1821A,
} NiFpga_MyRio1900Fpga10_ControlU16;

#endif

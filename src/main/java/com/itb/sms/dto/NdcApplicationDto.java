package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NdcApplicationDto {

    @JsonProperty("APP_MODE")
    private String APP_MODE;

    @JsonProperty("APP_ROLL_NO")
    private String APP_ROLL_NO;

    @JsonProperty("APP_CAT")
    private String APP_CAT;

    @JsonProperty("imdata")
    private String imdata;

    @JsonProperty("STD_NAME")
    private String STD_NAME;

    @JsonProperty("STD_MOBILE_NO")
    private String STD_MOBILE_NO;

    @JsonProperty("RG_CODE")
    private String RG_CODE;

    @JsonProperty("RG_SECT")
    private String RG_SECT;

    @JsonProperty("F_NAME")
    private String F_NAME;

    @JsonProperty("F_MOBILE_NO")
    private String F_MOBILE_NO;

    @JsonProperty("M_NAME")
    private String M_NAME;

    @JsonProperty("M_MOBILE_NO")
    private String M_MOBILE_NO;

    @JsonProperty("SCHOOL_NAME")
    private String SCHOOL_NAME;

    @JsonProperty("BOARD_CODE")
    private String BOARD_CODE;

    @JsonProperty("EXAM_ROLL_NO")
    private String EXAM_ROLL_NO;

    @JsonProperty("REG_NO")
    private String REG_NO;

    @JsonProperty("SESSION_NO")
    private String SESSION_NO;

    @JsonProperty("EXAM_YEAR")
    private String EXAM_YEAR;

    @JsonProperty("LOC_CODE")
    private String LOC_CODE;

    @JsonProperty("SSC_GR_CODE")
    private String SSC_GR_CODE;

    @JsonProperty("GP_BANG")
    private String GP_BANG;

    @JsonProperty("GP_ENG")
    private String GP_ENG;

    @JsonProperty("GP_RELI")
    private String GP_RELI;

    @JsonProperty("GP_MATH")
    private String GP_MATH;

    @JsonProperty("GP_PHY")
    private String GP_PHY;

    @JsonProperty("GP_CHE")
    private String GP_CHE;

    @JsonProperty("GP_BIO")
    private String GP_BIO;

    @JsonProperty("GP_HMATH")
    private String GP_HMATH;

    @JsonProperty("GP_SCI")
    private String GP_SCI;

    @JsonProperty("GP_ACC")
    private String GP_ACC;

    @JsonProperty("ADD_SUB_NAME")
    private String ADD_SUB_NAME;

    @JsonProperty("GP_ADD_SUB")
    private String GP_ADD_SUB;

    @JsonProperty("SSC_GPA")
    private String SSC_GPA;

    @JsonProperty("TOTAL_APLUS")
    private String TOTAL_APLUS;

    @JsonProperty("SSC_MARKS")
    private String SSC_MARKS;

    @JsonProperty("SSC_VERSION")
    private String SSC_VERSION;

    @JsonProperty("SMS_MOBILE_NO")
    private String SMS_MOBILE_NO;

    @JsonProperty("EXAM_SUB_NAME1")
    private String EXAM_SUB_NAME1;

    @JsonProperty("GP_EXAM_SUB1")
    private String GP_EXAM_SUB1;

    @JsonProperty("EXAM_SUB_NAME2")
    private String EXAM_SUB_NAME2;

    @JsonProperty("GP_EXAM_SUB2")
    private String GP_EXAM_SUB2;

    @JsonProperty("EXAM_SUB_NAME3")
    private String EXAM_SUB_NAME3;

    @JsonProperty("GP_EXAM_SUB3")
    private String GP_EXAM_SUB3;

    @JsonProperty("EXAM_SUB_NAME4")
    private String EXAM_SUB_NAME4;

    @JsonProperty("GP_EXAM_SUB4")
    private String GP_EXAM_SUB4;

    @JsonProperty("OTP")
    private String OTP;

    @JsonProperty("TB_EXAM_ROLL_NO")
    private String TB_EXAM_ROLL_NO;

    @JsonProperty("TB_REG_NO")
    private String TB_REG_NO;

    @JsonProperty("GP_ECO")
    private String GP_ECO;

    @JsonProperty("GP_CIVICS")
    private String GP_CIVICS;

    @JsonProperty("GP_GEO")
    private String GP_GEO;

    @JsonProperty("GP_QURAN")
    private String GP_QURAN;

    @JsonProperty("GP_ARABIC")
    private String GP_ARABIC;

    @JsonProperty("GP_AQAID")
    private String GP_AQAID;

    @JsonProperty("GP_ISLAM")
    private String GP_ISLAM;

    @JsonProperty("GP_SCIENCE")
    private String GP_SCIENCE;

    @JsonProperty("GP_FIN")
    private String GP_FIN;

    @JsonProperty("GP_BUSINT")
    private String GP_BUSINT;

    @JsonProperty("TOTAL_MARKS")
    private String TOTAL_MARKS;


}

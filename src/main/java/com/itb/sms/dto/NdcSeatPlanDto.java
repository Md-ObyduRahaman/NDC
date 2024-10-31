package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcSeatPlanDto {

    @JsonProperty("STD_NAME")
    private String STD_NAME;

    @JsonProperty("APP_ROLL_NO")
    private String APP_ROLL_NO;

    @JsonProperty("STD_MOBILE_NO")
    private String STD_MOBILE_NO;

    @JsonProperty("F_NAME")
    private String F_NAME;

    @JsonProperty("APP_CAT")
    private String APP_CAT;

    @JsonProperty("F_MOBILE_NO")
    private String F_MOBILE_NO;

    @JsonProperty("M_NAME")
    private String M_NAME;

    @JsonProperty("M_MOBILE_NO")
    private String M_MOBILE_NO;

    @JsonProperty("EXAM_TIME")
    private String EXAM_TIME;

    @JsonProperty("EXAM_DATE")
    private String EXAM_DATE;

    @JsonProperty("ROOM_NO")
    private String ROOM_NO;

    @JsonProperty("BUILDING_NO")
    private String BUILDING_NO;

    @JsonProperty("FLOOR_NO")
    private String FLOOR_NO;


}

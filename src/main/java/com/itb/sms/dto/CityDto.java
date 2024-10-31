package com.itb.sms.dto;

import lombok.Data;

@Data
public class CityDto {

    private Long id;
    private String cityName;
    private Long stateId;
    private String stateName;
    private String status;
    private String deleted="N";



}

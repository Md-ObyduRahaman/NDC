package com.itb.sms.dto;

import lombok.Data;

@Data
public class StateDto {

    private Long id;
    private String stateName;
    private Long countryId;
    private String countryName;
    private String status;
    private String deleted="N";



}

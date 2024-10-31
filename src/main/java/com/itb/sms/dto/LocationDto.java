package com.itb.sms.dto;

import lombok.Data;

@Data
public class LocationDto {

    private Long id;
    private String locationName;
    private String status;
    private String deleted="N";



}

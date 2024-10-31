package com.itb.sms.dto;

import lombok.Data;

@Data
public class ReligionDto {

    private Long id;
    private String religionName;
    private String status;
    private String deleted="N";



}

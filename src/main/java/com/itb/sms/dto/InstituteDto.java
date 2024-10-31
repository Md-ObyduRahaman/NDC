package com.itb.sms.dto;

import lombok.Data;

@Data
public class InstituteDto {

    private Long id;
    private String instituteName;
    private String logo;
    private Long countryId;
    private String countryName;
    private String status;



}

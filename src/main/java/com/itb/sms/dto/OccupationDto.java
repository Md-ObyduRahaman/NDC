package com.itb.sms.dto;

import lombok.Data;

@Data
public class OccupationDto {

    private Long id;
    private String occupationName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

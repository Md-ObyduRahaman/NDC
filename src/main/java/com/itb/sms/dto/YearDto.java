package com.itb.sms.dto;

import lombok.Data;

@Data
public class YearDto {

    private Long id;
    private String yearName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

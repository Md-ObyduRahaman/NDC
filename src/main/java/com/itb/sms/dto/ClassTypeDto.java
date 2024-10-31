package com.itb.sms.dto;

import lombok.Data;

@Data
public class ClassTypeDto {

    private Long id;
    private String typeName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

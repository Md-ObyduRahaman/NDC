package com.itb.sms.dto;

import lombok.Data;

@Data
public class MajorDto {

    private Long id;
    private String majorName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

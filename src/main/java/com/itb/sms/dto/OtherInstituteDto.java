package com.itb.sms.dto;

import lombok.Data;

@Data
public class OtherInstituteDto {

    private Long id;
    private String instituteName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

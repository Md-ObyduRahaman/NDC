package com.itb.sms.dto;

import lombok.Data;

@Data
public class SalaryGradeDto {

    private Long id;
    private String gradeName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

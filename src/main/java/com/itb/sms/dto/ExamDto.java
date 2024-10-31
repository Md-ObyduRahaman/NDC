package com.itb.sms.dto;

import lombok.Data;

@Data
public class ExamDto {

    private Long id;
    private String examName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

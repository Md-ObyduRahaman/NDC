package com.itb.sms.dto;

import lombok.Data;

@Data
public class SubjectDto {

    private Long id;
    private String subjectName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

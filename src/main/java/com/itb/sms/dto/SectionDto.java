package com.itb.sms.dto;

import lombok.Data;

@Data
public class SectionDto {

    private Long id;
    private String sectionName;
    private Long classId;
    private String className;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

package com.itb.sms.dto;

import lombok.Data;

@Data
public class SessionDto {

    private Long id;
    private String sessionName;
    private Long classId;
    private String className;
    private Long yearId;
    private String yearName;
    private Long facultyId;
    private String facultyName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

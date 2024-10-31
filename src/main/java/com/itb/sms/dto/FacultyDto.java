package com.itb.sms.dto;

import lombok.Data;

@Data
public class FacultyDto {

    private Long id;
    private String facultyName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

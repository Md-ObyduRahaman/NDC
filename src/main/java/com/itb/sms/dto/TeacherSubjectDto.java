package com.itb.sms.dto;

import lombok.Data;

@Data
public class TeacherSubjectDto {

    private Long id;
    private String teachSubjectName;
    private Long employeeId;
    private String employeeName;
    private Long subjectId;
    private String subjectName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

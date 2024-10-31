package com.itb.sms.dto;

import lombok.Data;

@Data
public class SubjectBookDto {

    private Long id;
    private String subBookName;
    private Long subjectId;
    private String subjectName;
    private Long bookId;
    private String bookName;
    private Long subjectTypeId;
    private String subjectTypeName;
    private Long sessionId;
    private String sessionName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

package com.itb.sms.dto;

import lombok.Data;

@Data
public class ClassRoutineDto {

    private Long id;
    private Long classId;
    private String className;
    private Long sectionId;
    private String sectionName;
    private Long subjectId;
    private String subjectName;
    private Long sessionId;
    private String sessionName;
    private Long teacherId;
    private String teacherName;
    private String day;
    private Long roomId;
    private String roomName;
    private String startTime;
    private String endTime;
    private Long instituteId;
    private Long branchId;
    private String deleted="N";


}

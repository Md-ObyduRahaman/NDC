package com.itb.sms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {

    private Long id;
    private String empCode;
    private String empName;
    private String fatherName;
    private String motherName;
    private Long typeId;
    private String typeName;
    private Long designationId;
    private String designationName;
    private String nationalId;
    private Byte gender;
    private Byte maritalStatus;
    private String spouseName;
    private String bloodGroup;
    private Long religionId;
    private String religionName;
    private Date dob;
    private Date joiningDate;
    private String presentAddress;
    private String permanentAddress;
    private String contactNo1;
    private String contactNo2;
    private String email;
    private String picture;
    private String teachingStatus;
    private Integer orderNo;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

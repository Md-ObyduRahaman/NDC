package com.itb.sms.dto;

import lombok.Data;

import java.util.Date;

@Data
public class StudentDto {

    private Long id;
    private String udStudentId;
    private String studentName;
    private Byte typeId;
    private String studentTypeName;
    private String fatherName;
    private Long fatherOccupationId;
    private String fatherOccupationName;
    private String motherName;
    private Long motherOccupationId;
    private String motherOccupationName;
    private String fatherNationalId;
    private String motherNationalId;
    private String fatherMobileNo;
    private String motherMobileNo;
    private Date dob;
    private String age;
    private String birthRegNo;
    private String placeOfBirth;
    private Byte gender;
    private String bloodGroup;
    private Byte maritalStatus;
    private Long religionId;
    private String religionName;
    private String nationality;
    private String ethnicity;
    private Long   quotaId;
    private String quotaName;
    private String disability;
    private String email;
    private String annualIncome;
    private String picture;

    private Long presentAddressId;
    private Long presentDivisionId;
    private String presentDivisionName;
    private Long presentDistrictId;
    private String presentDistrictName;
    private Long presentThanaId;
    private String presentThanaName;
    private Long presentUnionId;
    private String presentUnionName;
    private String presentPostOffice;
    private String presentPostCode;
    private String presentAddress;
    private Long presentAreaStatusId;
    private String presentAreaStatusName;
    private Long presentGeoLocationId;
    private String presentGeoLocationName;

    private Long permanentAddressId;
    private Long permanentDivisionId;
    private String permanentDivisionName;
    private Long permanentDistrictId;
    private String permanentDistrictName;
    private Long permanentThanaId;
    private String permanentThanaName;
    private Long permanentUnionId;
    private String permanentUnionName;
    private String permanentPostOffice;
    private String permanentPostCode;
    private String permanentAddress;
    private Long permanentAreaStatusId;
    private String permanentAreaStatusName;
    private String permanentGeoLocationId;
    private String permanentGeoLocationName;


    private Long gurdianId;
    private String nameOfGurdian;
    private String relation;
    private String gurdianContactNo;
    private String gurdianEmail;
    private Long gurdianOccupationId;
    private String gurdianOccupationName;
    private String gurdianAnnualIncome;

    private Long gurdianDivisionId;
    private String gurdianDivisionName;
    private Long gurdianDistrictId;
    private String gurdianDistrictName;
    private Long gurdianThanaId;
    private String gurdianThanaName;
    private Long gurdianUnionId;
    private String gurdianUnionName;
    private String gurdianPostOffice;
    private String gurdianPostCode;
    private String gurdianAddress;
    private String gurdianAreaStatusId;
    private String gurdianAreaStatusName;
    private String gurdianGeoLocationId;
    private String gurdianGeoLocationName;

    private Long academicRecordId;
    private Long classId;
    private Long sectionId;
    private Byte shiftId;
    private Long groupId;
    private Long sessionId;
    private String rollNo;
    private Date admissionDate;
    private String admissionNo;
    private String regNo;
    private String stipendStatus="N";
    private String stipendType;
    private String scholarshipStatus="N";
    private String scholarshipType;
    private String repeaterStatus="N";
    private String transferStatus="N";
    private String eiin;
    private String dropOutStatus="N";
    private String versionStatus="N";

    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

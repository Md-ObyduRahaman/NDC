package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "ed_student")
public class StudentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(sequenceName = "ed_student_seq", allocationSize = 1, name = "student_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ud_student_id", nullable = false, length = 30)
    private String udStudentId;

    @Column(name = "student_name", nullable = false, length = 50)
    private String studentName;

    @Column(name = "type_id", length = 1)
    private Byte typeId;

    @Column(name = "father_name", nullable = false, length = 50)
    private String fatherName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "father_occupation_id")
    private OccupationInfo fatherOccupationInfo;

    @Column(name = "father_national_id", length = 20)
    private String fatherNationalId;

    @Column(name = "mother_name", nullable = false, length = 50)
    private String motherName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mother_occupation_id")
    private OccupationInfo motherOccupationInfo;

    @Column(name = "mother_national_id",  length = 20)
    private String motherNationalId;


    @Column(name = "father_mobile_no",length = 15)
    private String fatherMobileNo;

    @Column(name = "mother_mobile_no",  length = 15)
    private String motherMobileNo;

    @Column(name = "birth_place", length = 50)
    private String placeOfBirth;

    @Type(type = "date")
    @Column(name = "dob")
    private Date dob;

    @Column(name = "age", length = 30)
    private String age;

    @Column(name = "birth_reg_no",  length = 25)
    private String birthRegNo;

    @Lob
    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "gender", length = 1)
    private Byte gender;

    @Column(name = "blood_group", length = 4)
    private String bloodGroup;

    @Column(name = "marital_status", length = 1)
    private Byte maritalStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "religion_id")
    private ReligionInfo religionInfo;

    @Column(name = "nationality", length = 30)
    private String nationality;

    @Column(name = "ethnicity", length = 30)
    private String ethnicity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quota_id")
    private QuotaInfo quotaInfo;

    @Column(name = "disability", length = 30)
    private String disability;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "annual_income", length = 7)
    private String annualIncome;

    @Column(name = "academic_record_id",length = 20)
    private Long academicRecordId;

    @Column(name = "is_deleted")
    private String deleted;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_by", insertable = false)
    private Long updatedBy;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}

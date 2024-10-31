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
@Table(name = "ed_employee")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(sequenceName = "ed_employee_seq", allocationSize = 1, name = "emp_seq")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="emp_code", nullable=false,length = 20)
    private String empCode;

    @Column(name="emp_name", nullable=false,length = 50)
    private String empName;

    @Column(name="father_name", nullable=false,length = 50)
    private String fatherName;

    @Column(name="mother_name", nullable=false,length = 50)
    private String motherName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private EmployeeTypeInfo typeInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "designation_id")
    private DesignationInfo designationInfo;

    @Column(name = "national_id",length = 20)
    private String nationalId;

    @Column(name = "gender",length = 1)
    private Byte gender;

    @Column(name = "marital_status",length = 1)
    private Byte maritalStatus;

    @Column(name="spouse_name", nullable=false,length = 50)
    private String spouseName;

   @Column(name = "blood_group",length = 4)
    private String bloodGroup;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "religion_id")
    private ReligionInfo religionInfo;

    @Type(type = "date")
    @Column(name = "dob")
    private Date dob;

    @Type(type = "date")
    @Column(name = "joining_date")
    private Date joiningDate;

    @Column(name = "present_address")
    private String presentAddress;

    @Column(name = "permanent_address")
    private String permanentAddress;

    @Column(name = "contact_no1")
    private String contactNo1;

    @Column(name = "contact_no2")
    private String contactNo2;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @Column(name = "teaching_status")
    private String teachingStatus;


    @Column(name = "order_no", nullable = false, length = 3)
    private Integer orderNo;

    @Column(name = "status")
    private String status;

    @Column(name = "is_deleted")
    private String deleted;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "created_by",updatable=false)
    private Long createdBy;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_by",insertable=false)
    private Long updatedBy;

    @Column(name = "updated_at",insertable=false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}

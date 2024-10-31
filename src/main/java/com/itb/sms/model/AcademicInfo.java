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
@Table(name = "ed_academic_record")
public class AcademicInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "academic_seq")
    @SequenceGenerator(sequenceName = "ed_academic_seq", allocationSize = 1, name = "academic_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentInfo studentInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private ClassInfo classInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id")
    private SectionInfo sectionInfo;

    @Column(name = "shift_id", nullable = false, length = 1)
    private Byte shiftId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "group_id")
    private GroupInfo groupInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")
    private SessionInfo sessionInfo;

    @Column(name = "roll_no", nullable = false, length = 20)
    private String rollNo;

    @Type(type = "date")
    @Column(name = "admission_date")
    private Date admissionDate;

    @Column(name = "admission_no", nullable = false, length = 20)
    private String admissionNo;

    @Column(name = "reg_no", length = 20)
    private String regNo;

    @Column(name = "stipend_status",nullable = false)
    private String stipendStatus;

    @Column(name = "stipend_type")
    private String stipendType;

    @Column(name = "scholarship_status",nullable = false)
    private String scholarshipStatus;

    @Column(name = "scholarship_type")
    private String scholarshipType;

    @Column(name = "repeater_status")
    private String repeaterStatus;

    @Column(name = "transfer_status")
    private String transferStatus;

    @Column(name = "eiin")
    private String eiin;

    @Column(name = "drop_out_status")
    private String dropOutStatus;

    @Column(name = "version_status")
    private String versionStatus;

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

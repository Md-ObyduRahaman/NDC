package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_teacher_subject")
public class TeacherSubjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teach_sub_seq")
    @SequenceGenerator(sequenceName = "ed_teacher_subject_seq", allocationSize = 1, name = "teach_sub_seq")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "teacher_subject_name", nullable = false,length = 50)
    private String teachSubjectName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id")
    private EmployeeInfo employeeInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_id")
    private SubjectInfo subjectInfo;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "is_deleted")
    private String deleted;

    @Column(name = "created_by",updatable = false)
    private Long createdBy;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_by",insertable = false)
    private Long updatedBy;

    @Column(name = "updated_at",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;


}

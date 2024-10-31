package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_faculty")
public class FacultyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FACULTY_SEQ")
    @SequenceGenerator(sequenceName = "ED_FACULTY_SEQ", allocationSize = 1, name = "FACULTY_SEQ")
    @Column(name="faculty_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "faculty_name", nullable = false,length = 50)
    private String facultyName;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "status",nullable = false)
    private String status;

    @Column(name = "is_deleted")
    private String deleted;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_at",insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateAt;


}

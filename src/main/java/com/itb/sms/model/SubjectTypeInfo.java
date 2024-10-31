package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_sub_type")
public class SubjectTypeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUB_TYPE_SEQ")
    @SequenceGenerator(sequenceName = "ED_SUB_TYPE_SEQ", allocationSize = 1, name = "SUB_TYPE_SEQ")
    @Column(name="sb_type_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "type_name", nullable = false,length = 50)
    private String typeName;

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

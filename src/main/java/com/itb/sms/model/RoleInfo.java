package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_roles")
public class RoleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_SEQ")
    @SequenceGenerator(sequenceName = "ED_ROLE_SEQ", allocationSize = 1, name = "ROLE_SEQ")
    @Column(name="role_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "role_code", nullable = false,length = 15)
    private String roleCode;

    @Column(name = "role_name", nullable = false,length = 50)
    private String roleName;

    @Column(name = "default_status",nullable = false)
    private String defaultStatus;

    @Column(name = "super_admin_status",nullable = false)
    private String superAdminStatus;

    @Column(name = "status",nullable = false)
    private String status;

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

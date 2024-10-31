package com.itb.sms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ed_users")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(sequenceName = "ED_MODULE_SEQ", allocationSize = 1, name = "USER_SEQ")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password_name")
    private String password;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleInfo roleInfo;

    @Column(name = "type_id")
    private Long typeId;

    @Column(name = "email")
    private String email;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Lob
    @Column(name = "photo", length = Integer.MAX_VALUE)
    private String photo;

    @Column(name = "status")
    private String status;

    @Column(name = "create_by")
    private String createdBy;

    @Column(name = "update_by")
    private String updatedBy;

    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "update_date")
    private Date updatedDate;



}

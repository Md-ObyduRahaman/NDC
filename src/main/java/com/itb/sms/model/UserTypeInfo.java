package com.itb.sms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ed_user_type")
public class UserTypeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password_name")
    private String password;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "created")
    private String created;

    @Column(name = "email")
    private String email;

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

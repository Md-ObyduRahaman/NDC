package com.itb.sms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ed_menu")
public class MenuInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_id")
    private long id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_url")
    private String menuUrl;


    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "lev")
    private Long level;

    @Column(name = "par_menu_id")
    private Long parentMenuId;



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

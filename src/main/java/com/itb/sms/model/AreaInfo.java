package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_area")
public class AreaInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ED_AREA_SEQ")
    @SequenceGenerator(sequenceName = "ED_AREA_SEQ", allocationSize = 1, name = "ED_AREA_SEQ")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "area_name", nullable = false,length = 50)
    private String areaName;


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

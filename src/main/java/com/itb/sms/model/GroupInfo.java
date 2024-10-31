package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_group")
public class GroupInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ED_GROUP_SEQ")
    @SequenceGenerator(sequenceName = "ED_GROUP_SEQ", allocationSize = 1, name = "ED_GROUP_SEQ")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name = "group_name", nullable = false,length = 50)
    private String groupName;


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

package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "role_assinged_menus")
public class RoleMenuInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_MENU_SEQ")
    @SequenceGenerator(sequenceName = "role_assinged_menus_seq", allocationSize = 1, name = "ROLE_MENU_SEQ")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleInfo roleInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    private MenuEntity menuInfo;

    @Column(name = "create_status")
    private String createStatus;

    @Column(name = "read_status")
    private String readStatus;

    @Column(name = "update_status")
    private String updateStatus;

    @Column(name = "delete_status")
    private String deleteStatus;

    @Column(name = "created_by",updatable=false)
    private Long createdBy;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createdAt;


}

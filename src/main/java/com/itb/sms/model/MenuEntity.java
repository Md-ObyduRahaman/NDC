package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_menus")
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MENU_SEQ")
    @SequenceGenerator(sequenceName = "ED_MENU_SEQ", allocationSize = 1, name = "MENU_SEQ")
    @Column(name = "id")
    private Long id;

    @Column(name = "menu_name", nullable = false, length = 50)
    private String menuName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_id")
    private ModuleInfo moduleInfo;

    @Column(name = "order_no", nullable = false, length = 3)
    private Integer orderNo;

    @Column(name = "url", nullable = false, length = 100)
    private String url;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_by",updatable=false)
    private Long createdBy;

    @Column(name = "created_at", updatable=false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_by",insertable=false)
    private Long updatedBy;

    @Column(name = "updated_at",insertable=false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;



}

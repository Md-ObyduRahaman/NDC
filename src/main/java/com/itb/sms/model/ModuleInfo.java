package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_modules")
public class ModuleInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MODULE_SEQ")
    @SequenceGenerator(sequenceName = "ED_MODULE_SEQ", allocationSize = 1, name = "MODULE_SEQ")
    @Column(name = "module_id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "module_name", nullable = false, length = 50)
    private String moduleName;

    @Column(name = "icon", nullable = false, length = 30)
    private String icon;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "order_no", nullable = false, length = 3)
    private Integer orderNo;

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

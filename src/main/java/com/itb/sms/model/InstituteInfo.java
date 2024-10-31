package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_institutes")
public class InstituteInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INST_SEQ")
    @SequenceGenerator(sequenceName = "ED_INSTITUTE_SEQ", allocationSize = 1, name = "INST_SEQ")
    @Column(name="institute_id", nullable=false, unique=true)
    private Long id;

    @Column(name="institute_name", nullable=false,length = 200)
    private String instituteName;

    @Lob
    @Column(name = "logo", length = Integer.MAX_VALUE)
    private String logo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private CountryInfo countryInfo;

    @Column(name = "status",nullable = false)
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

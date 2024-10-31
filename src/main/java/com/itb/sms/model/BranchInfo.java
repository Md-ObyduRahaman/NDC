package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_inst_br")
public class BranchInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANCH_SEQ")
    @SequenceGenerator(sequenceName = "ED_INST_BR_SEQ", allocationSize = 1, name = "BRANCH_SEQ")
    @Column(name="br_id", nullable=false, unique=true)
    private Long id;

    @Column(name="branch_name", nullable=false,length = 50)
    private String branchName;

    @Lob
    @Column(name = "logo", length = Integer.MAX_VALUE)
    private String logo;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CityInfo cityInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private PostInfo postInfo;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "status")
    private String status;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "is_deleted")
    private String deleted;

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

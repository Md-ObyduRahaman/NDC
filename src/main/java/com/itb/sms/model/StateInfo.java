package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_state")
public class StateInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_SEQ")
    @SequenceGenerator(sequenceName = "ED_STATE_SEQ", allocationSize = 1, name = "STATE_SEQ")
    @Column(name="state_id", nullable=false, unique=true)
    private Long id;

    @Column(name="state_name", nullable=false,length = 50)
    private String stateName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private CountryInfo countryInfo;

    @Column(name = "status")
    private String status;

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

package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_building")
public class BuildingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUILDING_SEQ")
    @SequenceGenerator(sequenceName = "ED_BUILDING_SEQ", allocationSize = 1, name = "BUILDING_SEQ")
    @Column(name="building_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "building_name", nullable = false,length = 50)
    private String buildingName;

    @Column(name = "no_of_room")
    private Integer noOfRoom;

    @Lob
    @Column(name = "picture", length = Integer.MAX_VALUE)
    private String picture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private CityInfo cityInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private PostInfo postInfo;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private String status;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

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

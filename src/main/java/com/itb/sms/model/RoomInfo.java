package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_room")
public class RoomInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROOM_SEQ")
    @SequenceGenerator(sequenceName = "ED_ROOM_SEQ", allocationSize = 1, name = "ROOM_SEQ")
    @Column(name="room_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "room_name", nullable = false,length = 50)
    private String roomName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private RoomTypeInfo typeInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private BuildingInfo buildingInfo;

    @Column(name = "no_seat")
    private Integer noOfSeat;

    @Column(name = "status")
    private String status;

    @Column(name = "ac_status")
    private String acStatus;

    @Column(name = "remark")
    private String remarks;

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

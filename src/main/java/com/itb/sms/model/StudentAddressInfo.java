package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "ed_student_address")
public class StudentAddressInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(sequenceName = "ed_address_seq", allocationSize = 1, name = "address_seq")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type_id", length = 1)
    private Byte typeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private StudentInfo studentInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "division_id")
    private StateInfo divisionInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id")
    private CityInfo districtInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "thana_id")
    private PostInfo thanaInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "union_id")
    private UnionInfo unionInfo;

    @Column(name = "post_office", nullable = false, length = 50)
    private String postOffice;

    @Column(name = "post_code", nullable = false, length = 50)
    private String postCode;

    @Column(name = "address", nullable = false, length = 500)
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private AreaInfo areaInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private LocationInfo locationInfo;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_by", insertable = false)
    private Long updatedBy;

    @Column(name = "updated_at", insertable = false)
    @UpdateTimestamp
    private LocalDateTime updateDateTime;


}

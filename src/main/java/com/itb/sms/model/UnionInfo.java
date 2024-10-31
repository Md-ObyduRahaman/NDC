package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_union")
public class UnionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNION_SEQ")
    @SequenceGenerator(sequenceName = "ED_UNION_SEQ", allocationSize = 1, name = "UNION_SEQ")
    @Column(name="id", nullable=false, unique=true)
    private Long id;

    @Column(name="union_name", nullable=false,length = 50)
    private String unionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private PostInfo postInfo;

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

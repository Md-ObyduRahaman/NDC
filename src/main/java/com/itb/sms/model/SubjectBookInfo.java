package com.itb.sms.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ed_sub_book")
public class SubjectBookInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subject_book_seq")
    @SequenceGenerator(sequenceName = "ed_sub_book_seq", allocationSize = 1, name = "subject_book_seq")
    @Column(name="sb_bk_id", nullable=false, unique=true)
    private Long id;

    @Column(name = "sub_book_name", nullable = false,length = 50)
    private String subBookName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sb_type_id")
    private SubjectTypeInfo subjectTypeInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sub_id")
    private SubjectInfo subjectInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private BookInfo bookInfo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "session_id")
    private SessionInfo sessionInfo;

    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "status",nullable = false)
    private String status;

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

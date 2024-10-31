package com.itb.sms.repository;


import com.itb.sms.model.SubjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectInfo, Long> {



}
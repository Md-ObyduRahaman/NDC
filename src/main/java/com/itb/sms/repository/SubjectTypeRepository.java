package com.itb.sms.repository;


import com.itb.sms.model.ClassTypeInfo;
import com.itb.sms.model.SubjectTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectTypeRepository extends JpaRepository<SubjectTypeInfo, Long> {



}
package com.itb.sms.repository;


import com.itb.sms.model.EmployeeTypeInfo;
import com.itb.sms.model.SubjectTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeInfo, Long> {



}
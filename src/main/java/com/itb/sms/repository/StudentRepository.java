package com.itb.sms.repository;


import com.itb.sms.model.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentInfo, Long> {



}
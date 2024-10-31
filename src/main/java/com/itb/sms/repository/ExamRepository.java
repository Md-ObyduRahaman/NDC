package com.itb.sms.repository;


import com.itb.sms.model.BookInfo;
import com.itb.sms.model.ExamInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<ExamInfo, Long> {



}
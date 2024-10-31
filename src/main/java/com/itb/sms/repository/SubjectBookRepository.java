package com.itb.sms.repository;


import com.itb.sms.model.SubjectBookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectBookRepository extends JpaRepository<SubjectBookInfo, Long> {



}
package com.itb.sms.repository;


import com.itb.sms.model.YearInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface YearRepository extends JpaRepository<YearInfo, Long> {



}
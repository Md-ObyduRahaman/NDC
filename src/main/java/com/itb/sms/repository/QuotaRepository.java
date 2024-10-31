package com.itb.sms.repository;


import com.itb.sms.model.QuotaInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotaRepository extends JpaRepository<QuotaInfo, Long> {



}
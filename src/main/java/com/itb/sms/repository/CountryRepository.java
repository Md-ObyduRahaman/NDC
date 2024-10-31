package com.itb.sms.repository;


import com.itb.sms.model.CountryInfo;
import com.itb.sms.model.InstituteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryInfo, Long> {



}
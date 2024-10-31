package com.itb.sms.repository;


import com.itb.sms.model.CityInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityInfo, Long> {



}
package com.itb.sms.repository;


import com.itb.sms.model.BuildingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingInfo, Long> {



}
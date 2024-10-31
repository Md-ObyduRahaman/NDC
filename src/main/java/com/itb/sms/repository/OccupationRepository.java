package com.itb.sms.repository;


import com.itb.sms.model.OccupationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<OccupationInfo, Long> {



}
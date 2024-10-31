package com.itb.sms.repository;


import com.itb.sms.model.ReligionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReligionRepository extends JpaRepository<ReligionInfo, Long> {


}
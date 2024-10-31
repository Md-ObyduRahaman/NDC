package com.itb.sms.repository;



import com.itb.sms.model.LocationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationInfo, Long> {



}
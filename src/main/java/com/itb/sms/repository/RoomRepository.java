package com.itb.sms.repository;


import com.itb.sms.model.RoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomInfo, Long> {



}
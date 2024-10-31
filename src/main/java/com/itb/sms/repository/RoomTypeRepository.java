package com.itb.sms.repository;


import com.itb.sms.model.FacultyInfo;
import com.itb.sms.model.RoomTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomTypeInfo, Long> {



}
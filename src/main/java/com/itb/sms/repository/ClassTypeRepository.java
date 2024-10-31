package com.itb.sms.repository;


import com.itb.sms.model.ClassTypeInfo;
import com.itb.sms.model.RoomTypeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassTypeRepository extends JpaRepository<ClassTypeInfo, Long> {



}
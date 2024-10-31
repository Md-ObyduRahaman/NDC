package com.itb.sms.repository;


import com.itb.sms.model.StudentAddressInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAddressRepository extends JpaRepository<StudentAddressInfo, Long> {



}
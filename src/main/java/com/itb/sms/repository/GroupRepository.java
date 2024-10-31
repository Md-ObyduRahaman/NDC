package com.itb.sms.repository;


import com.itb.sms.model.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupInfo, Long> {



}
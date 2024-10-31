package com.itb.sms.repository;


import com.itb.sms.model.BranchInfo;
import com.itb.sms.model.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleInfo, Long> {



}
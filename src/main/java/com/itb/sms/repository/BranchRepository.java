package com.itb.sms.repository;


import com.itb.sms.model.BranchInfo;
import com.itb.sms.model.InstituteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchInfo, Long> {



}
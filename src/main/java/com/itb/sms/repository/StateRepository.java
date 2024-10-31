package com.itb.sms.repository;


import com.itb.sms.model.BranchInfo;
import com.itb.sms.model.StateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateInfo, Long> {



}
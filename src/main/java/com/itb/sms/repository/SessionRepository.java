package com.itb.sms.repository;


import com.itb.sms.model.SessionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionInfo, Long> {



}
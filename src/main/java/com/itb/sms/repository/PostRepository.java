package com.itb.sms.repository;


import com.itb.sms.model.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostInfo, Long> {



}
package com.itb.sms.repository;


import com.itb.sms.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserInfo, Long> {


    @Query("SELECT u FROM UserInfo u WHERE lower(u.username) =:username")
    UserInfo findByUsername(@Param("username") String username);

}
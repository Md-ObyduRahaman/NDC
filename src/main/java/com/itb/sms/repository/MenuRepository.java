package com.itb.sms.repository;


import com.itb.sms.model.MenuInfo;
import com.itb.sms.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuInfo, Long> {

    @Query("SELECT m FROM MenuInfo m WHERE m.roleId=:roleId and m.parentMenuId is null ")
    List<MenuInfo> findParentMenuByRoleId(@Param("roleId") Long roleId );

    @Query("SELECT m FROM MenuInfo m WHERE m.roleId=:roleId and m.parentMenuId is not null ")
    List<MenuInfo> findChildMenuByRoleId(@Param("roleId") Long roleId);

}
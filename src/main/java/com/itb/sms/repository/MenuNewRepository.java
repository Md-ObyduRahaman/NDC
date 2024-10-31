package com.itb.sms.repository;


import com.itb.sms.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuNewRepository extends JpaRepository<MenuEntity, Long> {

    @Query("SELECT m FROM MenuEntity m WHERE m.id NOT IN (SELECT um.menuInfo.id FROM RoleMenuInfo um WHERE um.roleInfo.id =:roleId)")
    List<MenuEntity> findUnAssignedMenus(@Param("roleId") Long roleId);





}
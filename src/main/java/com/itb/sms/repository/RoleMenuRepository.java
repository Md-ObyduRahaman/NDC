package com.itb.sms.repository;

import com.itb.sms.model.MenuEntity;
import com.itb.sms.model.RoleMenuInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface RoleMenuRepository extends JpaRepository<RoleMenuInfo, Long> {

    @Query("SELECT rm FROM RoleMenuInfo rm WHERE rm.roleInfo.id=:roleId order by rm.menuInfo.id")
    List<RoleMenuInfo> findAssignedMenus(@Param("roleId") Long roleId);

    @Modifying
    @Transactional
    @Query(nativeQuery =true,value = "DELETE from role_assinged_menus where menu_id=:menuId and role_id=:roleId")
    void removeRoleMenu(@Param("menuId") Long menuId, @Param("roleId") Long roleId);


}
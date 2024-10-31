package com.itb.sms.repository;


import com.itb.sms.model.ModuleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleInfo, Long> {

    @Query("SELECT md FROM ModuleInfo md WHERE md.id  IN (SELECT mn.moduleInfo.id FROM MenuEntity mn join RoleMenuInfo um on mn.id=um.menuInfo.id WHERE um.roleInfo.id =:roleId)")
    List<ModuleInfo> findModuleByRoleId(@Param("roleId") Long roleId);
}
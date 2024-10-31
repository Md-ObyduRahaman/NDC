package com.itb.sms.service;

import com.itb.sms.dto.RoleDto;

import java.util.List;


public interface RoleService {

    RoleDto getById(Long id);

    List<RoleDto> findAll(String superAdminStatus);

    void saveOrUpdate(RoleDto dto);

}

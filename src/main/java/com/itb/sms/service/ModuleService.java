package com.itb.sms.service;


import com.itb.sms.dto.ModuleInfoDto;

import java.util.List;

public interface ModuleService {

    ModuleInfoDto getModuleById(Long id);

    List<ModuleInfoDto> getModules(String status);

    List<ModuleInfoDto> getModulesByRoleId(Long roleId);

    void saveOrUpdate(ModuleInfoDto moduleInfoDto);
}

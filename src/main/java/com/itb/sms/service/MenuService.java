package com.itb.sms.service;

import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.model.MenuInfo;

import java.util.List;

public interface MenuService {

    List<MenuInfo> getParentMenuByRoleId(Long roleId);

    List<MenuInfo> getChildMenuByRoleId(Long roleId);

    MenuInfoDto getMenuById(Long id);

    List<MenuInfoDto> findAll(String status);

    List<MenuInfoDto> getUnAssignedMenus(Long roleId);

    /*List<ModuleInfoDto> getModulesByUserId(Long userId);*/

    void saveOrUpdate(MenuInfoDto dto);



}

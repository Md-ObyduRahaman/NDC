package com.itb.sms.mapper;


import com.itb.sms.dto.*;
import com.itb.sms.model.*;
import com.itb.sms.repository.MenuNewRepository;
import com.itb.sms.repository.RoleRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RoleMenuMapper {


    private final UserService userService;
    private final MenuNewRepository menuNewRepository;
    private final RoleRepository roleRepository;

    public RoleMenuMapper(UserService userService,MenuNewRepository menuNewRepository,RoleRepository roleRepository) {
        this.userService = userService;
        this.menuNewRepository = menuNewRepository;
        this.roleRepository = roleRepository ;
    }



    public RoleMenuInfo map(RoleMenuInfoDto dto) {

        UserInfo loggedInUser = userService.getCurrentUser();

        RoleMenuInfo entity = new RoleMenuInfo();
        Optional<MenuEntity> menuInfo = menuNewRepository.findById(dto.getMenuId());
        if (menuInfo.isPresent()) {
            entity.setMenuInfo(menuInfo.get());
        } else {

            new Exception("Menu is not exist with id " + dto.getMenuId());
        }

        Optional<RoleInfo> roleInfo = roleRepository.findById(dto.getRoleId());
        if (roleInfo.isPresent()) {
            entity.setRoleInfo(roleInfo.get());
        } else {

            new Exception("Role is not exist with id " + dto.getRoleId());
        }
        entity.setCreateStatus(dto.getCreateStatus());
        entity.setReadStatus(dto.getReadStatus());
        entity.setUpdateStatus(dto.getUpdateStatus());
        entity.setDeleteStatus(dto.getDeleteStatus());
        entity.setCreatedBy(loggedInUser.getId());


        return entity;

    }

    public List<RoleMenuInfoDto> mapList(List<RoleMenuInfo> entities) {
        List<RoleMenuInfoDto> list = new ArrayList<>();

        RoleMenuInfoDto dto;

        for (RoleMenuInfo entity : entities) {

            dto = new RoleMenuInfoDto();
            dto.setId(entity.getId());
            dto.setMenuId(entity.getMenuInfo().getId());
            dto.setMenuName(entity.getMenuInfo().getMenuName());
            dto.setUrl(entity.getMenuInfo().getUrl());
            dto.setRoleId(entity.getRoleInfo().getId());
            dto.setRoleName(entity.getRoleInfo().getRoleName());
            dto.setModuleId(entity.getMenuInfo().getModuleInfo().getId());
            dto.setModuleName(entity.getMenuInfo().getModuleInfo().getModuleName());

            list.add(dto);
        }

        return list;


    }

    public RoleMenuInfoDto map(RoleMenuInfo entity) {

        RoleMenuInfoDto dto = new RoleMenuInfoDto();

        dto.setId(entity.getId());
        dto.setMenuId(entity.getMenuInfo().getId());
        dto.setMenuName(entity.getMenuInfo().getMenuName());
        dto.setUrl(entity.getMenuInfo().getUrl());
        dto.setRoleId(entity.getRoleInfo().getId());
        dto.setRoleName(entity.getRoleInfo().getRoleName());
        dto.setModuleId(entity.getMenuInfo().getModuleInfo().getId());
        dto.setModuleName(entity.getMenuInfo().getModuleInfo().getModuleName());

        return dto;


    }
}

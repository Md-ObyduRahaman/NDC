package com.itb.sms.mapper;


import com.itb.sms.dto.RoleDto;
import com.itb.sms.model.RoleInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {


    private final UserService userService;

    public RoleMapper(UserService userService) {
        this.userService = userService;
    }


    public RoleInfo map(RoleDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        RoleInfo entity = new RoleInfo();
        entity.setId(dto.getId());
        entity.setRoleName(dto.getRoleName());
        entity.setRoleCode(dto.getRoleCode());
        entity.setDefaultStatus(dto.getDefaultStatus());
        entity.setSuperAdminStatus(dto.getSuperAdminStatus());
        entity.setStatus(dto.getStatus());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<RoleDto> mapList(List<RoleInfo> entities) {
        List<RoleDto> list = new ArrayList<>();

        RoleDto dto;

        for (RoleInfo entity : entities) {

            dto = new RoleDto();
            dto.setId(entity.getId());
            dto.setRoleName(entity.getRoleName());
            dto.setRoleCode(entity.getRoleCode());
            dto.setStatus(entity.getStatus());

            list.add(dto);
        }

        return list;


    }


    public RoleDto map(RoleInfo entity) {

        RoleDto dto = new RoleDto();

        dto.setId(entity.getId());
        dto.setRoleName(entity.getRoleName());
        dto.setRoleCode(entity.getRoleCode());
        dto.setStatus(entity.getStatus());


        return dto;


    }
}

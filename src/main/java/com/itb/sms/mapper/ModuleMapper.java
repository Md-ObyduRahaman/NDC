package com.itb.sms.mapper;


import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.model.ModuleInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModuleMapper {


    private final UserService userService;

    public ModuleMapper(UserService userService) {
        this.userService = userService;
    }


    public ModuleInfo map(ModuleInfoDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ModuleInfo entity = new ModuleInfo();
        entity.setId(dto.getId());
        entity.setModuleName(dto.getModuleName());
        entity.setIcon(dto.getIcon());
        entity.setRemarks(dto.getRemarks());
        entity.setOrderNo(dto.getOrderNo());
        entity.setStatus(dto.getStatus());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<ModuleInfoDto> mapList(List<ModuleInfo> entities) {
        List<ModuleInfoDto> list = new ArrayList<>();

        ModuleInfoDto dto;

        for (ModuleInfo entity : entities) {

            dto = new ModuleInfoDto();
            dto.setId(entity.getId());
            dto.setModuleName(entity.getModuleName());
            dto.setIcon(entity.getIcon());
            dto.setRemarks(entity.getRemarks());
            dto.setOrderNo(entity.getOrderNo());
            dto.setStatus(entity.getStatus());

            list.add(dto);
        }

        return list;


    }


    public ModuleInfoDto map(ModuleInfo entity) {

        ModuleInfoDto dto = new ModuleInfoDto();

        dto.setId(entity.getId());
        dto.setModuleName(entity.getModuleName());
        dto.setIcon(entity.getIcon());
        dto.setRemarks(entity.getRemarks());
        dto.setOrderNo(entity.getOrderNo());
        dto.setStatus(entity.getStatus());


        return dto;


    }
}

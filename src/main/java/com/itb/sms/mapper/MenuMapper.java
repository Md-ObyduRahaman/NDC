package com.itb.sms.mapper;


import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.model.MenuEntity;
import com.itb.sms.model.ModuleInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ModuleRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MenuMapper {


    private final UserService userService;
    private final ModuleRepository moduleRepository;

    public MenuMapper(UserService userService,ModuleRepository moduleRepository) {

        this.userService = userService;
        this.moduleRepository = moduleRepository;
    }


    public MenuEntity map(MenuInfoDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        MenuEntity entity = new MenuEntity();
        entity.setId(dto.getId());
        entity.setMenuName(dto.getMenuName());

        Optional<ModuleInfo> moduleInfo = moduleRepository.findById(dto.getModuleId());
        if (moduleInfo.isPresent()) {
            entity.setModuleInfo(moduleInfo.get());
        } else {

            new Exception("Module is not exist with id " + dto.getModuleId());
        }
        entity.setOrderNo(dto.getOrderNo());
        entity.setStatus(dto.getStatus());
        entity.setUrl(dto.getUrl());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<MenuInfoDto> mapList(List<MenuEntity> entities) {
        List<MenuInfoDto> list = new ArrayList<>();

        MenuInfoDto dto;

        for (MenuEntity entity : entities) {

            dto = new MenuInfoDto();
            dto.setId(entity.getId());
            dto.setMenuName(entity.getMenuName());
            dto.setModuleId(entity.getModuleInfo().getId());
            dto.setModuleName(entity.getModuleInfo().getModuleName());
            dto.setOrderNo(entity.getOrderNo());
            dto.setUrl(entity.getUrl());
            dto.setStatus(entity.getStatus());

            list.add(dto);
        }

        return list;


    }


    public MenuInfoDto map(MenuEntity entity) {

        MenuInfoDto dto = new MenuInfoDto();

        dto.setId(entity.getId());
        dto.setMenuName(entity.getMenuName());
        dto.setModuleId(entity.getModuleInfo().getId());
        dto.setModuleName(entity.getModuleInfo().getModuleName());
        dto.setOrderNo(entity.getOrderNo());
        dto.setUrl(entity.getUrl());
        dto.setStatus(entity.getStatus());


        return dto;


    }
}

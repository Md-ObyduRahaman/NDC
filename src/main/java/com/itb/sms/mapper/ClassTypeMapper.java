package com.itb.sms.mapper;


import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.model.ClassTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassTypeMapper {


    private final UserService userService;

    public ClassTypeMapper(UserService userService) {
        this.userService = userService;
    }


    public ClassTypeInfo map(ClassTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ClassTypeInfo entity = new ClassTypeInfo();
        entity.setId(dto.getId());
        entity.setTypeName(dto.getTypeName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<ClassTypeDto> mapList(List<ClassTypeInfo> entities) {
        List<ClassTypeDto> list = new ArrayList<>();

        ClassTypeDto dto;

        for (ClassTypeInfo entity : entities) {

            dto = new ClassTypeDto();
            dto.setId(entity.getId());
            dto.setTypeName(entity.getTypeName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public ClassTypeDto map(ClassTypeInfo entity) {

        ClassTypeDto dto = new ClassTypeDto();

        dto.setId(entity.getId());
        dto.setTypeName(entity.getTypeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

package com.itb.sms.mapper;


import com.itb.sms.dto.EmployeeTypeDto;
import com.itb.sms.model.EmployeeTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeTypeMapper {


    private final UserService userService;

    public EmployeeTypeMapper(UserService userService) {
        this.userService = userService;
    }


    public EmployeeTypeInfo map(EmployeeTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        EmployeeTypeInfo entity = new EmployeeTypeInfo();
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


    public List<EmployeeTypeDto> mapList(List<EmployeeTypeInfo> entities) {
        List<EmployeeTypeDto> list = new ArrayList<>();

        EmployeeTypeDto dto;

        for (EmployeeTypeInfo entity : entities) {

            dto = new EmployeeTypeDto();
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


    public EmployeeTypeDto map(EmployeeTypeInfo entity) {

        EmployeeTypeDto dto = new EmployeeTypeDto();

        dto.setId(entity.getId());
        dto.setTypeName(entity.getTypeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

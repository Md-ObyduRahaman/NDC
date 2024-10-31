package com.itb.sms.mapper;


import com.itb.sms.dto.SubjectTypeDto;
import com.itb.sms.model.SubjectTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectTypeMapper {


    private final UserService userService;

    public SubjectTypeMapper(UserService userService) {
        this.userService = userService;
    }


    public SubjectTypeInfo map(SubjectTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SubjectTypeInfo entity = new SubjectTypeInfo();
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


    public List<SubjectTypeDto> mapList(List<SubjectTypeInfo> entities) {
        List<SubjectTypeDto> list = new ArrayList<>();

        SubjectTypeDto dto;

        for (SubjectTypeInfo entity : entities) {

            dto = new SubjectTypeDto();
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


    public SubjectTypeDto map(SubjectTypeInfo entity) {

        SubjectTypeDto dto = new SubjectTypeDto();

        dto.setId(entity.getId());
        dto.setTypeName(entity.getTypeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

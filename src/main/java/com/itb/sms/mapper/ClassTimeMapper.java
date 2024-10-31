package com.itb.sms.mapper;


import com.itb.sms.dto.ClassTimeDto;
import com.itb.sms.model.ClassTimeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassTimeMapper {


    private final UserService userService;

    public ClassTimeMapper(UserService userService) {
        this.userService = userService;
    }


    public ClassTimeInfo map(ClassTimeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ClassTimeInfo entity = new ClassTimeInfo();
        entity.setId(dto.getId());
        entity.setTimeName(dto.getTimeName());
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


    public List<ClassTimeDto> mapList(List<ClassTimeInfo> entities) {
        List<ClassTimeDto> list = new ArrayList<>();

        ClassTimeDto dto;

        for (ClassTimeInfo entity : entities) {

            dto = new ClassTimeDto();
            dto.setId(entity.getId());
            dto.setTimeName(entity.getTimeName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public ClassTimeDto map(ClassTimeInfo entity) {

        ClassTimeDto dto = new ClassTimeDto();

        dto.setId(entity.getId());
        dto.setTimeName(entity.getTimeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

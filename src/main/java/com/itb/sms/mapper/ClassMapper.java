package com.itb.sms.mapper;


import com.itb.sms.dto.ClassDto;
import com.itb.sms.model.ClassInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassMapper {


    private final UserService userService;

    public ClassMapper(UserService userService) {
        this.userService = userService;
    }


    public ClassInfo map(ClassDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ClassInfo entity = new ClassInfo();
        entity.setId(dto.getId());
        entity.setClassName(dto.getClassName());
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


    public List<ClassDto> mapList(List<ClassInfo> entities) {
        List<ClassDto> list = new ArrayList<>();

        ClassDto dto;

        for (ClassInfo entity : entities) {

            dto = new ClassDto();
            dto.setId(entity.getId());
            dto.setClassName(entity.getClassName());
             dto.setStatus(entity.getStatus());
             dto.setDeleted(entity.getDeleted());
             dto.setInstituteId(entity.getInstituteId());
             dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public ClassDto map(ClassInfo entity) {

        ClassDto dto = new ClassDto();

        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setStatus(entity.getStatus());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

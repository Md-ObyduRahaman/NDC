package com.itb.sms.mapper;


import com.itb.sms.dto.FacultyDto;
import com.itb.sms.model.FacultyInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FacultyMapper {


    private final UserService userService;

    public FacultyMapper(UserService userService) {
        this.userService = userService;
    }


    public FacultyInfo map(FacultyDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        FacultyInfo entity = new FacultyInfo();
        entity.setId(dto.getId());
        entity.setFacultyName(dto.getFacultyName());
        entity.setStatus(dto.getStatus());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());
        entity.setDeleted(dto.getDeleted());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<FacultyDto> mapList(List<FacultyInfo> entities) {
        List<FacultyDto> list = new ArrayList<>();

        FacultyDto dto;

        for (FacultyInfo entity : entities) {

            dto = new FacultyDto();
            dto.setId(entity.getId());
            dto.setFacultyName(entity.getFacultyName());
             dto.setStatus(entity.getStatus());
             dto.setInstituteId(entity.getInstituteId());
             dto.setBranchId(entity.getBranchId());
            dto.setDeleted(entity.getDeleted());
            list.add(dto);
        }

        return list;


    }


    public FacultyDto map(FacultyInfo entity) {

        FacultyDto dto = new FacultyDto();

        dto.setId(entity.getId());
        dto.setFacultyName(entity.getFacultyName());
        dto.setStatus(entity.getStatus());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }
}

package com.itb.sms.mapper;


import com.itb.sms.dto.DesignationDto;
import com.itb.sms.model.DesignationInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DesignationMapper {


    private final UserService userService;

    public DesignationMapper(UserService userService) {
        this.userService = userService;
    }


    public DesignationInfo map(DesignationDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        DesignationInfo entity = new DesignationInfo();
        entity.setId(dto.getId());
        entity.setDesignationName(dto.getDesignationName());
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


    public List<DesignationDto> mapList(List<DesignationInfo> entities) {
        List<DesignationDto> list = new ArrayList<>();

        DesignationDto dto;

        for (DesignationInfo entity : entities) {

            dto = new DesignationDto();
            dto.setId(entity.getId());
            dto.setDesignationName(entity.getDesignationName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public DesignationDto map(DesignationInfo entity) {

        DesignationDto dto = new DesignationDto();

        dto.setId(entity.getId());
        dto.setDesignationName(entity.getDesignationName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

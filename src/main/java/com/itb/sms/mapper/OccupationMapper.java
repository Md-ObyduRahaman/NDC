package com.itb.sms.mapper;


import com.itb.sms.dto.OccupationDto;
import com.itb.sms.model.OccupationInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OccupationMapper {


    private final UserService userService;

    public OccupationMapper(UserService userService) {
        this.userService = userService;
    }


    public OccupationInfo map(OccupationDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        OccupationInfo entity = new OccupationInfo();
        entity.setId(dto.getId());
        entity.setOccupationName(dto.getOccupationName());
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


    public List<OccupationDto> mapList(List<OccupationInfo> entities) {
        List<OccupationDto> list = new ArrayList<>();

        OccupationDto dto;

        for (OccupationInfo entity : entities) {

            dto = new OccupationDto();
            dto.setId(entity.getId());
            dto.setOccupationName(entity.getOccupationName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public OccupationDto map(OccupationInfo entity) {

        OccupationDto dto = new OccupationDto();

        dto.setId(entity.getId());
        dto.setOccupationName(entity.getOccupationName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

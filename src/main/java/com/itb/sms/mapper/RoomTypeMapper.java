package com.itb.sms.mapper;


import com.itb.sms.dto.RoomTypeDto;
import com.itb.sms.model.RoomTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoomTypeMapper {


    private final UserService userService;

    public RoomTypeMapper(UserService userService) {
        this.userService = userService;
    }


    public RoomTypeInfo map(RoomTypeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        RoomTypeInfo entity = new RoomTypeInfo();
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


    public List<RoomTypeDto> mapList(List<RoomTypeInfo> entities) {
        List<RoomTypeDto> list = new ArrayList<>();

        RoomTypeDto dto;

        for (RoomTypeInfo entity : entities) {

            dto = new RoomTypeDto();
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


    public RoomTypeDto map(RoomTypeInfo entity) {

        RoomTypeDto dto = new RoomTypeDto();

        dto.setId(entity.getId());
        dto.setTypeName(entity.getTypeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

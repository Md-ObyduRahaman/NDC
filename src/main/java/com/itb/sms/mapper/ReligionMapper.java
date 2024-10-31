package com.itb.sms.mapper;


import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.dto.ReligionDto;
import com.itb.sms.model.ClassTypeInfo;
import com.itb.sms.model.ReligionInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReligionMapper {


    private final UserService userService;

    public ReligionMapper(UserService userService) {
        this.userService = userService;
    }


    public ReligionInfo map(ReligionDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ReligionInfo entity = new ReligionInfo();
        entity.setId(dto.getId());
        entity.setReligionName(dto.getReligionName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<ReligionDto> mapList(List<ReligionInfo> entities) {
        List<ReligionDto> list = new ArrayList<>();

        ReligionDto dto;

        for (ReligionInfo entity : entities) {

            dto = new ReligionDto();
            dto.setId(entity.getId());
            dto.setReligionName(entity.getReligionName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }


    public ReligionDto map(ReligionInfo entity) {

        ReligionDto dto = new ReligionDto();

        dto.setId(entity.getId());
        dto.setReligionName(entity.getReligionName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

package com.itb.sms.mapper;


import com.itb.sms.dto.AreaDto;
import com.itb.sms.model.AreaInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AreaMapper {


    private final UserService userService;

    public AreaMapper(UserService userService) {
        this.userService = userService;
    }


    public AreaInfo map(AreaDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        AreaInfo entity = new AreaInfo();
        entity.setId(dto.getId());
        entity.setAreaName(dto.getAreaName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<AreaDto> mapList(List<AreaInfo> entities) {
        List<AreaDto> list = new ArrayList<>();

        AreaDto dto;

        for (AreaInfo entity : entities) {

            dto = new AreaDto();
            dto.setId(entity.getId());
            dto.setAreaName(entity.getAreaName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }


    public AreaDto map(AreaInfo entity) {

        AreaDto dto = new AreaDto();

        dto.setId(entity.getId());
        dto.setAreaName(entity.getAreaName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

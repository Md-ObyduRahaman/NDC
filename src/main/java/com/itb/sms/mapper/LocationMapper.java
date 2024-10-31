package com.itb.sms.mapper;


import com.itb.sms.dto.LocationDto;
import com.itb.sms.model.LocationInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LocationMapper {


    private final UserService userService;

    public LocationMapper(UserService userService) {
        this.userService = userService;
    }


    public LocationInfo map(LocationDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        LocationInfo entity = new LocationInfo();
        entity.setId(dto.getId());
        entity.setLocationName(dto.getLocationName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<LocationDto> mapList(List<LocationInfo> entities) {
        List<LocationDto> list = new ArrayList<>();

        LocationDto dto;

        for (LocationInfo entity : entities) {

            dto = new LocationDto();
            dto.setId(entity.getId());
            dto.setLocationName(entity.getLocationName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }


    public LocationDto map(LocationInfo entity) {

        LocationDto dto = new LocationDto();

        dto.setId(entity.getId());
        dto.setLocationName(entity.getLocationName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

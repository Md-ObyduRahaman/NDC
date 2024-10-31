package com.itb.sms.mapper;

import com.itb.sms.dto.CountryDto;
import com.itb.sms.model.CountryInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryMapper {


    private final UserService userService;

    public CountryMapper(UserService userService) {
        this.userService = userService;
    }


    public CountryInfo map(CountryDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        CountryInfo entity = new CountryInfo();
        entity.setId(dto.getId());
        entity.setCountryName(dto.getCountryName());
        entity.setStatus(dto.getStatus());
        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<CountryDto> mapList(List<CountryInfo> entities) {
        List<CountryDto> list = new ArrayList<>();

        CountryDto dto;

        for (CountryInfo entity : entities) {

            dto = new CountryDto();
            dto.setId(entity.getId());
            dto.setCountryName(entity.getCountryName());
            dto.setStatus(entity.getStatus());

            list.add(dto);
        }

        return list;


    }


    public CountryDto map(CountryInfo entity) {

        CountryDto dto= new CountryDto();

        dto.setId(entity.getId());
        dto.setCountryName(entity.getCountryName());
        dto.setStatus(entity.getStatus());

        return dto;


    }
}

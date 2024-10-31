package com.itb.sms.mapper;


import com.itb.sms.dto.YearDto;
import com.itb.sms.model.YearInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class YearMapper {


    private final UserService userService;

    public YearMapper(UserService userService) {
        this.userService = userService;
    }


    public YearInfo map(YearDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        YearInfo entity = new YearInfo();
        entity.setId(dto.getId());
        entity.setYearName(dto.getYearName());
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


    public List<YearDto> mapList(List<YearInfo> entities) {
        List<YearDto> list = new ArrayList<>();

        YearDto dto;

        for (YearInfo entity : entities) {

            dto = new YearDto();
            dto.setId(entity.getId());
            dto.setYearName(entity.getYearName());
             dto.setStatus(entity.getStatus());
             dto.setDeleted(entity.getDeleted());
             dto.setInstituteId(entity.getInstituteId());
             dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public YearDto map(YearInfo entity) {

        YearDto dto = new YearDto();

        dto.setId(entity.getId());
        dto.setYearName(entity.getYearName());
        dto.setStatus(entity.getStatus());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

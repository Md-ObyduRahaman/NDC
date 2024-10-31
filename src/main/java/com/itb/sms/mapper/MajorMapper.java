package com.itb.sms.mapper;


import com.itb.sms.dto.MajorDto;
import com.itb.sms.model.MajorInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MajorMapper {


    private final UserService userService;

    public MajorMapper(UserService userService) {
        this.userService = userService;
    }


    public MajorInfo map(MajorDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        MajorInfo entity = new MajorInfo();
        entity.setId(dto.getId());
        entity.setMajorName(dto.getMajorName());
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


    public List<MajorDto> mapList(List<MajorInfo> entities) {
        List<MajorDto> list = new ArrayList<>();

        MajorDto dto;

        for (MajorInfo entity : entities) {

            dto = new MajorDto();
            dto.setId(entity.getId());
            dto.setMajorName(entity.getMajorName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public MajorDto map(MajorInfo entity) {

        MajorDto dto = new MajorDto();

        dto.setId(entity.getId());
        dto.setMajorName(entity.getMajorName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

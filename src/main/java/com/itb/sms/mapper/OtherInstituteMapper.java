package com.itb.sms.mapper;


import com.itb.sms.dto.OtherInstituteDto;
import com.itb.sms.model.OtherInstituteInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OtherInstituteMapper {


    private final UserService userService;

    public OtherInstituteMapper(UserService userService) {
        this.userService = userService;
    }


    public OtherInstituteInfo map(OtherInstituteDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        OtherInstituteInfo entity = new OtherInstituteInfo();
        entity.setId(dto.getId());
        entity.setInstituteName(dto.getInstituteName());
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


    public List<OtherInstituteDto> mapList(List<OtherInstituteInfo> entities) {
        List<OtherInstituteDto> list = new ArrayList<>();

        OtherInstituteDto dto;

        for (OtherInstituteInfo entity : entities) {

            dto = new OtherInstituteDto();
            dto.setId(entity.getId());
            dto.setInstituteName(entity.getInstituteName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public OtherInstituteDto map(OtherInstituteInfo entity) {

        OtherInstituteDto dto = new OtherInstituteDto();

        dto.setId(entity.getId());
        dto.setInstituteName(entity.getInstituteName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

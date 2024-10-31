package com.itb.sms.mapper;


import com.itb.sms.dto.QuotaDto;
import com.itb.sms.model.QuotaInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuotaMapper {


    private final UserService userService;

    public QuotaMapper(UserService userService) {
        this.userService = userService;
    }


    public QuotaInfo map(QuotaDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        QuotaInfo entity = new QuotaInfo();
        entity.setId(dto.getId());
        entity.setQuotaName(dto.getQuotaName());
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


    public List<QuotaDto> mapList(List<QuotaInfo> entities) {
        List<QuotaDto> list = new ArrayList<>();

        QuotaDto dto;

        for (QuotaInfo entity : entities) {

            dto = new QuotaDto();
            dto.setId(entity.getId());
            dto.setQuotaName(entity.getQuotaName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public QuotaDto map(QuotaInfo entity) {

        QuotaDto dto = new QuotaDto();

        dto.setId(entity.getId());
        dto.setQuotaName(entity.getQuotaName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

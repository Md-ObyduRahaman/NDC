package com.itb.sms.mapper;


import com.itb.sms.dto.SalaryGradeDto;
import com.itb.sms.model.SalaryGradeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SalaryGradeMapper {


    private final UserService userService;

    public SalaryGradeMapper(UserService userService) {
        this.userService = userService;
    }


    public SalaryGradeInfo map(SalaryGradeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SalaryGradeInfo entity = new SalaryGradeInfo();
        entity.setId(dto.getId());
        entity.setGradeName(dto.getGradeName());
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


    public List<SalaryGradeDto> mapList(List<SalaryGradeInfo> entities) {
        List<SalaryGradeDto> list = new ArrayList<>();

        SalaryGradeDto dto;

        for (SalaryGradeInfo entity : entities) {

            dto = new SalaryGradeDto();
            dto.setId(entity.getId());
            dto.setGradeName(entity.getGradeName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public SalaryGradeDto map(SalaryGradeInfo entity) {

        SalaryGradeDto dto = new SalaryGradeDto();

        dto.setId(entity.getId());
        dto.setGradeName(entity.getGradeName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

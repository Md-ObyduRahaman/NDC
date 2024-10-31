package com.itb.sms.mapper;


import com.itb.sms.dto.ExamDto;
import com.itb.sms.model.ExamInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExamMapper {


    private final UserService userService;

    public ExamMapper(UserService userService) {
        this.userService = userService;
    }


    public ExamInfo map(ExamDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ExamInfo entity = new ExamInfo();
        entity.setId(dto.getId());
        entity.setExamName(dto.getExamName());
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


    public List<ExamDto> mapList(List<ExamInfo> entities) {
        List<ExamDto> list = new ArrayList<>();

        ExamDto dto;

        for (ExamInfo entity : entities) {

            dto = new ExamDto();
            dto.setId(entity.getId());
            dto.setExamName(entity.getExamName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public ExamDto map(ExamInfo entity) {

        ExamDto dto = new ExamDto();

        dto.setId(entity.getId());
        dto.setExamName(entity.getExamName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

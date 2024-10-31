package com.itb.sms.mapper;


import com.itb.sms.dto.SubjectDto;
import com.itb.sms.model.SubjectInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectMapper {


    private final UserService userService;

    public SubjectMapper(UserService userService) {
        this.userService = userService;
    }


    public SubjectInfo map(SubjectDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SubjectInfo entity = new SubjectInfo();
        entity.setId(dto.getId());
        entity.setSubjectName(dto.getSubjectName());
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


    public List<SubjectDto> mapList(List<SubjectInfo> entities) {
        List<SubjectDto> list = new ArrayList<>();

        SubjectDto dto;

        for (SubjectInfo entity : entities) {

            dto = new SubjectDto();
            dto.setId(entity.getId());
            dto.setSubjectName(entity.getSubjectName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public SubjectDto map(SubjectInfo entity) {

        SubjectDto dto = new SubjectDto();

        dto.setId(entity.getId());
        dto.setSubjectName(entity.getSubjectName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

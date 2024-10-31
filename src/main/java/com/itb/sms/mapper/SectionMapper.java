package com.itb.sms.mapper;


import com.itb.sms.dto.SectionDto;
import com.itb.sms.model.ClassInfo;
import com.itb.sms.model.ModuleInfo;
import com.itb.sms.model.SectionInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ClassRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SectionMapper {


    private final UserService userService;
    private final ClassRepository classRepository;

    public SectionMapper(UserService userService,ClassRepository classRepository) {
        this.userService = userService;
        this.classRepository = classRepository ;
    }


    public SectionInfo map(SectionDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SectionInfo entity = new SectionInfo();
        entity.setId(dto.getId());
        entity.setSectionName(dto.getSectionName());
        Optional<ClassInfo> classInfo = classRepository.findById(dto.getClassId());
        if (classInfo.isPresent()) {
            entity.setClassInfo(classInfo.get());
        } else {

            new Exception("Class is not exist with id " + dto.getClassId());
        }
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


    public List<SectionDto> mapList(List<SectionInfo> entities) {
        List<SectionDto> list = new ArrayList<>();

        SectionDto dto;

        for (SectionInfo entity : entities) {

            dto = new SectionDto();
            dto.setId(entity.getId());
            dto.setSectionName(entity.getSectionName());
            dto.setClassId(entity.getClassInfo().getId());
            dto.setClassName(entity.getClassInfo().getClassName());
             dto.setStatus(entity.getStatus());
             dto.setDeleted(entity.getDeleted());
             dto.setInstituteId(entity.getInstituteId());
             dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public SectionDto map(SectionInfo entity) {

        SectionDto dto = new SectionDto();

        dto.setId(entity.getId());
        dto.setSectionName(entity.getSectionName());
        dto.setClassId(entity.getClassInfo().getId());
        dto.setClassName(entity.getClassInfo().getClassName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());



        return dto;


    }
}

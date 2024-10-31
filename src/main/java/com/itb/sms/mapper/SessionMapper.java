package com.itb.sms.mapper;


import com.itb.sms.dto.SessionDto;
import com.itb.sms.model.*;
import com.itb.sms.repository.ClassRepository;
import com.itb.sms.repository.FacultyRepository;
import com.itb.sms.repository.YearRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SessionMapper {


    private final UserService userService;
    private final ClassRepository classRepository;
    private final YearRepository yearRepository;
    private final FacultyRepository facultyRepository;

    public SessionMapper(UserService userService, ClassRepository classRepository, FacultyRepository facultyRepository, YearRepository yearRepository) {
        this.userService = userService;
        this.classRepository = classRepository;
        this.facultyRepository = facultyRepository;
        this.yearRepository = yearRepository;
    }


    public SessionInfo map(SessionDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SessionInfo entity = new SessionInfo();
        entity.setId(dto.getId());
        entity.setSessionName(dto.getSessionName());
        Optional<ClassInfo> classInfo = classRepository.findById(dto.getClassId());
        if (classInfo.isPresent()) {
            entity.setClassInfo(classInfo.get());
        } else {

            new Exception("Class is not exist with id " + dto.getClassId());
        }

        Optional<FacultyInfo> facultyInfo = facultyRepository.findById(dto.getFacultyId());
        if (facultyInfo.isPresent()) {
            entity.setFacultyInfo(facultyInfo.get());
        } else {

            new Exception("Faculty is not exist with id " + dto.getFacultyId());
        }
        Optional<YearInfo> yearInfo = yearRepository.findById(dto.getYearId());
        if (yearInfo.isPresent()) {
            entity.setYearInfo(yearInfo.get());
        } else {

            new Exception("Year is not exist with id " + dto.getYearId());
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


    public List<SessionDto> mapList(List<SessionInfo> entities) {
        List<SessionDto> list = new ArrayList<>();

        SessionDto dto;

        for (SessionInfo entity : entities) {

            dto = new SessionDto();
            dto.setId(entity.getId());
            dto.setSessionName(entity.getSessionName());
            dto.setClassId(entity.getClassInfo().getId());
            dto.setClassName(entity.getClassInfo().getClassName());
            dto.setFacultyId(entity.getFacultyInfo().getId());
            dto.setFacultyName(entity.getFacultyInfo().getFacultyName());
            dto.setYearId(entity.getYearInfo().getId());
            dto.setYearName(entity.getYearInfo().getYearName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public SessionDto map(SessionInfo entity) {

        SessionDto dto = new SessionDto();

        dto.setId(entity.getId());
        dto.setSessionName(entity.getSessionName());
        dto.setClassId(entity.getClassInfo().getId());
        dto.setClassName(entity.getClassInfo().getClassName());
        dto.setFacultyId(entity.getFacultyInfo().getId());
        dto.setFacultyName(entity.getFacultyInfo().getFacultyName());
        dto.setYearId(entity.getYearInfo().getId());
        dto.setYearName(entity.getYearInfo().getYearName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

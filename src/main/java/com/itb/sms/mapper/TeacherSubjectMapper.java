package com.itb.sms.mapper;


import com.itb.sms.dto.TeacherSubjectDto;
import com.itb.sms.model.*;
import com.itb.sms.repository.*;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TeacherSubjectMapper {


    private final UserService userService;
    private final EmployeeRepository employeeRepository;
    private final SubjectRepository subjectRepository;

    public TeacherSubjectMapper(UserService userService, EmployeeRepository employeeRepository,
                                SubjectRepository subjectRepository) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.subjectRepository = subjectRepository ;
    }


    public TeacherSubjectInfo map(TeacherSubjectDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        TeacherSubjectInfo entity = new TeacherSubjectInfo();
        entity.setId(dto.getId());
        entity.setTeachSubjectName(dto.getTeachSubjectName());

        Optional<EmployeeInfo> employeeInfo=employeeRepository.findById(dto.getEmployeeId());
        if(employeeInfo.isPresent()){
            entity.setEmployeeInfo(employeeInfo.get());
        }else {

            new Exception("Teacher is not exist with id " + dto.getEmployeeId());
        }

        Optional<SubjectInfo> subjectInfo=subjectRepository.findById(dto.getSubjectId());
        if(subjectInfo.isPresent()){
            entity.setSubjectInfo(subjectInfo.get());
        }else {

            new Exception("Subject is not exist with id " + dto.getSubjectId());
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


    public List<TeacherSubjectDto> mapList(List<TeacherSubjectInfo> entities) {
        List<TeacherSubjectDto> list = new ArrayList<>();

        TeacherSubjectDto dto;

        for (TeacherSubjectInfo entity : entities) {

            dto = new TeacherSubjectDto();
            dto.setId(entity.getId());
            dto.setTeachSubjectName(entity.getTeachSubjectName());
            dto.setEmployeeId(entity.getEmployeeInfo().getId());
            dto.setEmployeeName(entity.getEmployeeInfo().getEmpName());
            dto.setSubjectId(entity.getSubjectInfo().getId());
            dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
           dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public TeacherSubjectDto map(TeacherSubjectInfo entity) {

        TeacherSubjectDto dto = new TeacherSubjectDto();

        dto.setId(entity.getId());
        dto.setTeachSubjectName(entity.getTeachSubjectName());
        dto.setEmployeeId(entity.getEmployeeInfo().getId());
        dto.setEmployeeName(entity.getEmployeeInfo().getEmpName());
        dto.setSubjectId(entity.getSubjectInfo().getId());
        dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

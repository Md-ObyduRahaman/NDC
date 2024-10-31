package com.itb.sms.mapper;

import com.itb.sms.dto.EmployeeDto;
import com.itb.sms.model.*;
import com.itb.sms.repository.DesignationRepository;
import com.itb.sms.repository.EmployeeRepository;
import com.itb.sms.repository.EmployeeTypeRepository;
import com.itb.sms.repository.ReligionRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class EmployeeMapper {


    private final UserService userService;
    private final EmployeeTypeRepository employeeTypeRepository;
    private final DesignationRepository designationRepository;
    private final ReligionRepository religionRepository;
    private final EmployeeRepository employeeRepository;


    public EmployeeMapper(UserService userService, EmployeeRepository employeeRepository,
                          EmployeeTypeRepository employeeTypeRepository, DesignationRepository designationRepository,
                          ReligionRepository religionRepository) {
        this.userService = userService;
        this.employeeRepository = employeeRepository;
        this.employeeTypeRepository = employeeTypeRepository;
        this.religionRepository = religionRepository;
        this.designationRepository = designationRepository;
    }


    public EmployeeInfo map(EmployeeDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        EmployeeInfo entity = new EmployeeInfo();

        entity.setId(dto.getId());

        if (dto.getId() == null) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            entity.setEmpCode(String.valueOf(timestamp.getTime()));
        } else {
            entity.setEmpCode(dto.getEmpCode());
        }
        entity.setEmpName(dto.getEmpName());
        entity.setFatherName(dto.getFatherName());
        entity.setMotherName(dto.getMotherName());

        Optional<EmployeeTypeInfo> typeInfo = employeeTypeRepository.findById(dto.getTypeId());
        if (typeInfo.isPresent()) {
            entity.setTypeInfo(typeInfo.get());
        } else {

            new Exception("Employee Type does not exist with id " + dto.getTypeId());
        }

        Optional<DesignationInfo> designationInfo = designationRepository.findById(dto.getDesignationId());
        if (designationInfo.isPresent()) {
            entity.setDesignationInfo(designationInfo.get());
        } else {

            new Exception("Designation does not exist with id " + dto.getDesignationId());
        }

        entity.setNationalId(dto.getNationalId());
        entity.setGender(dto.getGender());
        entity.setMaritalStatus(dto.getMaritalStatus());
        entity.setSpouseName(dto.getSpouseName());
        entity.setBloodGroup(dto.getBloodGroup());

        Optional<ReligionInfo> religionInfo = religionRepository.findById(dto.getReligionId());
        if (religionInfo.isPresent()) {
            entity.setReligionInfo(religionInfo.get());
        } else {

            new Exception("Religion does not exist with id " + dto.getDesignationId());
        }
        entity.setDob(dto.getDob());
        entity.setJoiningDate(dto.getJoiningDate());
        entity.setPresentAddress(dto.getPresentAddress());
        entity.setPermanentAddress(dto.getPermanentAddress());
        entity.setContactNo1(dto.getContactNo1());
        entity.setContactNo2(dto.getContactNo2());
        entity.setEmail(dto.getEmail());
        entity.setTeachingStatus(dto.getTeachingStatus());
        entity.setOrderNo(dto.getOrderNo());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setPicture(dto.getPicture());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());


        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<EmployeeDto> mapList(List<EmployeeInfo> entities) {
        List<EmployeeDto> list = new ArrayList<>();

        EmployeeDto dto;

        for (EmployeeInfo entity : entities) {

            dto = new EmployeeDto();

            dto.setId(entity.getId());
            dto.setEmpCode(entity.getEmpCode());
            dto.setEmpName(entity.getEmpName());
            dto.setFatherName(entity.getFatherName());
            dto.setMotherName(entity.getMotherName());
            dto.setTypeId(entity.getTypeInfo().getId());
            dto.setTypeName(entity.getTypeInfo().getTypeName());
            dto.setDesignationId(entity.getDesignationInfo().getId());
            dto.setDesignationName(entity.getDesignationInfo().getDesignationName());
            dto.setNationalId(entity.getNationalId());
            dto.setGender(entity.getGender());
            dto.setMaritalStatus(entity.getMaritalStatus());
            dto.setSpouseName(entity.getSpouseName());
            dto.setBloodGroup(entity.getBloodGroup());
            dto.setReligionId(entity.getReligionInfo().getId());
            dto.setReligionName(entity.getReligionInfo().getReligionName());
            dto.setDob(entity.getDob());
            dto.setJoiningDate(entity.getJoiningDate());
            dto.setPresentAddress(entity.getPresentAddress());
            dto.setPermanentAddress(entity.getPermanentAddress());
            dto.setContactNo1(entity.getContactNo1());
            dto.setContactNo2(entity.getContactNo2());
            dto.setEmail(entity.getEmail());
            dto.setPicture(entity.getPicture());
            dto.setTeachingStatus(entity.getTeachingStatus());
            dto.setOrderNo(entity.getOrderNo());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public EmployeeDto map(EmployeeInfo entity) {
        EmployeeDto dto = new EmployeeDto();

        dto.setId(entity.getId());
        dto.setEmpCode(entity.getEmpCode());
        dto.setEmpName(entity.getEmpName());
        dto.setFatherName(entity.getFatherName());
        dto.setMotherName(entity.getMotherName());
        dto.setTypeId(entity.getTypeInfo().getId());
        dto.setTypeName(entity.getTypeInfo().getTypeName());
        dto.setDesignationId(entity.getDesignationInfo().getId());
        dto.setDesignationName(entity.getDesignationInfo().getDesignationName());
        dto.setNationalId(entity.getNationalId());
        dto.setGender(entity.getGender());
        dto.setMaritalStatus(entity.getMaritalStatus());
        dto.setSpouseName(entity.getSpouseName());
        dto.setBloodGroup(entity.getBloodGroup());
        dto.setReligionId(entity.getReligionInfo().getId());
        dto.setReligionName(entity.getReligionInfo().getReligionName());
        dto.setDob(entity.getDob());
        dto.setJoiningDate(entity.getJoiningDate());
        dto.setPresentAddress(entity.getPresentAddress());
        dto.setPermanentAddress(entity.getPermanentAddress());
        dto.setContactNo1(entity.getContactNo1());
        dto.setContactNo2(entity.getContactNo2());
        dto.setEmail(entity.getEmail());
        dto.setPicture(entity.getPicture());
        dto.setTeachingStatus(entity.getTeachingStatus());
        dto.setOrderNo(entity.getOrderNo());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }

    public String generateUdEmployeeCode(Long instituteId, Long branchId) {
        StringBuilder udEmployeeId = new StringBuilder();
        int currentYear = Year.now().getValue();

        udEmployeeId.append(currentYear).append(employeeRepository.getUdEmployeeCode(instituteId, branchId));


        return udEmployeeId.toString();
    }
}

package com.itb.sms.mapper;


import com.itb.sms.dto.StudentDto;
import com.itb.sms.enums.StudentType;
import com.itb.sms.model.*;
import com.itb.sms.repository.*;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentMapper {


    private final UserService userService;
    private final OccupationRepository occupationRepository;
    private final ReligionRepository religionRepository;
    private final QuotaRepository quotaRepository;


    public StudentMapper(UserService userService, OccupationRepository occupationRepository, ReligionRepository religionRepository, QuotaRepository quotaRepository,
                         StateRepository stateRepository,CityRepository cityRepository,PostRepository postRepository,UnionRepository unionRepository,
                         AreaRepository areaRepository,LocationRepository locationRepository) {
        this.userService = userService;
        this.occupationRepository = occupationRepository;
        this.religionRepository = religionRepository;
        this.quotaRepository = quotaRepository;

    }


    public StudentInfo map(StudentDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        StudentInfo entity = new StudentInfo();
        entity.setId(dto.getId());
        if (dto.getId() == null) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            entity.setUdStudentId(String.valueOf(timestamp.getTime()));
        } else {
            entity.setUdStudentId(dto.getUdStudentId());
        }
        entity.setStudentName(dto.getStudentName());
        entity.setTypeId(dto.getTypeId());
        entity.setFatherName(dto.getFatherName());

        Optional<OccupationInfo> fatherOccupationInfo = occupationRepository.findById(dto.getFatherOccupationId());
        if (fatherOccupationInfo.isPresent()) {
            entity.setFatherOccupationInfo(fatherOccupationInfo.get());
        } else {

            new Exception("Occupation does not exist with id " + dto.getFatherOccupationId());
        }
        entity.setFatherNationalId(dto.getFatherNationalId());
        entity.setMotherName(dto.getMotherName());

        Optional<OccupationInfo> motherOccupationInfo = occupationRepository.findById(dto.getMotherOccupationId());
        if (motherOccupationInfo.isPresent()) {
            entity.setMotherOccupationInfo(motherOccupationInfo.get());
        } else {

            new Exception("Occupation does not exist with id " + dto.getMotherOccupationId());
        }
        entity.setMotherNationalId(dto.getMotherNationalId());
        entity.setFatherMobileNo(dto.getFatherMobileNo());
        entity.setMotherMobileNo(dto.getMotherMobileNo());
        entity.setPlaceOfBirth(dto.getPlaceOfBirth());
        entity.setDob(dto.getDob());
        entity.setAge(dto.getAge());
        entity.setBirthRegNo(dto.getBirthRegNo());
        entity.setPicture(dto.getPicture());
        entity.setGender(dto.getGender());
        entity.setBloodGroup(dto.getBloodGroup());
        entity.setMaritalStatus(dto.getMaritalStatus());

        Optional<ReligionInfo> religionInfo = religionRepository.findById(dto.getReligionId());
        if (religionInfo.isPresent()) {
            entity.setReligionInfo(religionInfo.get());
        } else {

            new Exception("Religion does not exist with id " + dto.getReligionId());
        }
        entity.setNationality(dto.getNationality());
        entity.setEthnicity(dto.getEthnicity());

        Optional<QuotaInfo> quotaInfo = quotaRepository.findById(dto.getQuotaId());
        if (quotaInfo.isPresent()) {
            entity.setQuotaInfo(quotaInfo.get());
        } else {

            new Exception("Quota does not exist with id " + dto.getQuotaId());
        }
        entity.setDisability(dto.getDisability());
        entity.setEmail(dto.getEmail());
        entity.setAnnualIncome(dto.getAnnualIncome());
        entity.setAcademicRecordId(dto.getAcademicRecordId());
        entity.setDeleted(dto.getDeleted());



        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<StudentDto> mapList(List<StudentInfo> entities) {
        List<StudentDto> list = new ArrayList<>();

        StudentDto dto;

        for (StudentInfo entity : entities) {

            dto = new StudentDto();
            dto.setId(entity.getId());
            dto.setUdStudentId(entity.getUdStudentId());
            dto.setStudentName(entity.getStudentName());
            dto.setTypeId(entity.getTypeId());
            dto.setStudentTypeName(StudentType.getValue(entity.getTypeId()));
            dto.setFatherName(entity.getFatherName());
            dto.setFatherOccupationId(entity.getFatherOccupationInfo().getId());
            dto.setFatherOccupationName(entity.getFatherOccupationInfo().getOccupationName());
            dto.setFatherNationalId(entity.getFatherNationalId());
            dto.setMotherName(entity.getMotherName());
            dto.setMotherOccupationId(entity.getMotherOccupationInfo().getId());
            dto.setMotherNationalId(entity.getMotherNationalId());
            dto.setFatherMobileNo(entity.getFatherMobileNo());
            dto.setMotherMobileNo(entity.getMotherMobileNo());
            dto.setPlaceOfBirth(entity.getPlaceOfBirth());
            dto.setDob(entity.getDob());
            dto.setAge(entity.getAge());
            dto.setBirthRegNo(entity.getBirthRegNo());
            dto.setPicture(entity.getPicture());
            dto.setGender(entity.getGender());
            dto.setBloodGroup(entity.getBloodGroup());
            dto.setMaritalStatus(entity.getMaritalStatus());
            dto.setReligionId(entity.getReligionInfo().getId());
            dto.setReligionName(entity.getReligionInfo().getReligionName());
            dto.setNationality(entity.getNationality());
            dto.setEthnicity(entity.getEthnicity());
            dto.setQuotaId(entity.getQuotaInfo().getId());
            dto.setQuotaName(entity.getQuotaInfo().getQuotaName());





            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }


    public StudentDto map(StudentInfo entity) {

        StudentDto dto = new StudentDto();

        dto.setId(entity.getId());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

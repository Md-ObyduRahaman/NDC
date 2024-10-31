package com.itb.sms.mapper;


import com.itb.sms.dto.ClassRoutineDto;
import com.itb.sms.dto.ExamDto;
import com.itb.sms.model.*;
import com.itb.sms.repository.*;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ClassRoutineMapper {


    private final UserService userService;
    private final SessionRepository sessionRepository;
    private final SectionRepository sectionRepository;
    private final SubjectRepository subjectRepository;
    private final EmployeeRepository employeeRepository;
    private final RoomRepository roomRepository;

    public ClassRoutineMapper(UserService userService, SessionRepository sessionRepository,
                              SectionRepository sectionRepository, SubjectRepository subjectRepository,
                              EmployeeRepository employeeRepository,RoomRepository roomRepository) {
        this.userService = userService;
        this.sessionRepository = sessionRepository;
        this.sectionRepository = sectionRepository;
        this.subjectRepository = subjectRepository ;
        this.employeeRepository = employeeRepository;
        this.roomRepository = roomRepository ;

    }


    public ClassRoutineInfo map(ClassRoutineDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        ClassRoutineInfo entity = new ClassRoutineInfo();
        entity.setId(dto.getId());

        Optional<SessionInfo> sessionInfo = sessionRepository.findById(dto.getSessionId());
        if (sessionInfo.isPresent()) {
            entity.setSessionInfo(sessionInfo.get());
            entity.setClassInfo(sessionInfo.get().getClassInfo());
        } else {

            new Exception("Session information does not exist " + dto.getSessionId());
        }

        Optional<SectionInfo> sectionInfo = sectionRepository.findById(dto.getSectionId());
        if (sectionInfo.isPresent()) {
            entity.setSectionInfo(sectionInfo.get());

        } else {

            new Exception("Section information does not exist " + dto.getSectionId());
        }

        Optional<SubjectInfo> subjectInfo = subjectRepository.findById(dto.getSubjectId());
        if (subjectInfo.isPresent()) {
            entity.setSubjectInfo(subjectInfo.get());

        } else {

            new Exception("Subject information does not exist " + dto.getSectionId());
        }
        Optional<EmployeeInfo> teacherInfo = employeeRepository.findById(dto.getTeacherId());
        if (teacherInfo.isPresent()) {
            entity.setTeacherInfo(teacherInfo.get());

        } else {

            new Exception("Teacher information does not exist " + dto.getTeacherId());
        }

        Optional<RoomInfo> roomInfo = roomRepository.findById(dto.getRoomId());
        if (roomInfo.isPresent()) {
            entity.setRoomInfo(roomInfo.get());

        } else {

            new Exception("Room information does not exist " + dto.getRoomId());
        }
        entity.setDay(dto.getDay());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());
        entity.setDeleted(dto.getDeleted());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }

    public List<ClassRoutineDto> mapList(List<ClassRoutineInfo> entities) {
        List<ClassRoutineDto> list = new ArrayList<>();

        ClassRoutineDto dto;

        for (ClassRoutineInfo entity : entities) {

            dto = new ClassRoutineDto();
            dto.setId(entity.getId());
            dto.setSessionId(entity.getSessionInfo().getId());
            dto.setSessionName(entity.getSessionInfo().getSessionName());
            dto.setClassId(entity.getClassInfo().getId());
            dto.setClassName(entity.getClassInfo().getClassName());
            dto.setSectionId(entity.getSectionInfo().getId());
            dto.setSectionName(entity.getSectionInfo().getSectionName());
            dto.setSubjectId(entity.getSubjectInfo().getId());
            dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
            dto.setTeacherId(entity.getTeacherInfo().getId());
            dto.setTeacherName(entity.getTeacherInfo().getEmpName());
            dto.setRoomId(entity.getRoomInfo().getId());
            dto.setRoomName(entity.getRoomInfo().getRoomName());
            dto.setDay(entity.getDay());
            dto.setStartTime(entity.getStartTime());
            dto.setEndTime(entity.getEndTime());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());
            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }

    public ClassRoutineDto map(ClassRoutineInfo entity) {

        ClassRoutineDto dto = new ClassRoutineDto();

        dto.setId(entity.getId());
        dto.setSessionId(entity.getSessionInfo().getId());
        dto.setSessionName(entity.getSessionInfo().getSessionName());
        dto.setClassId(entity.getClassInfo().getId());
        dto.setClassName(entity.getClassInfo().getClassName());
        dto.setSectionId(entity.getSectionInfo().getId());
        dto.setSectionName(entity.getSectionInfo().getSectionName());
        dto.setSubjectId(entity.getSubjectInfo().getId());
        dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
        dto.setTeacherId(entity.getTeacherInfo().getId());
        dto.setTeacherName(entity.getTeacherInfo().getEmpName());
        dto.setRoomId(entity.getRoomInfo().getId());
        dto.setRoomName(entity.getRoomInfo().getRoomName());
        dto.setDay(entity.getDay());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }


}

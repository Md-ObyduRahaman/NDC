package com.itb.sms.service.impl;

import com.itb.sms.dto.ClassRoutineDto;
import com.itb.sms.dto.RoomTypeDto;
import com.itb.sms.mapper.ClassRoutineMapper;
import com.itb.sms.model.ClassRoutineInfo;
import com.itb.sms.model.RoomTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ClassRoutineRepository;
import com.itb.sms.service.ClassRoutineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassRoutineServiceImpl implements ClassRoutineService {

    private final ClassRoutineMapper classRoutineMapper;
    private final ClassRoutineRepository classRoutineRepository;

    public ClassRoutineServiceImpl(ClassRoutineMapper classRoutineMapper, ClassRoutineRepository classRoutineRepository) {
        this.classRoutineMapper = classRoutineMapper;
        this.classRoutineRepository = classRoutineRepository;
    }

    @Override
    public ClassRoutineDto getById(Long id) {
        Optional<ClassRoutineInfo> entity = classRoutineRepository.findById(id);

        return classRoutineMapper.map(entity.get());

    }

    @Override
    public List<ClassRoutineDto> findRoutineList(UserInfo user, Long classId, Long sectionId, Long sessionId,String deleted) {


        return classRoutineMapper.mapList(classRoutineRepository.findAll().stream()
                .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                        && info.getBranchId().equals(user.getBranchId())
                        && info.getClassInfo().getId().equals(classId)
                        && info.getSectionInfo().getId().equals(sectionId)
                        && info.getSessionInfo().getId().equals(sessionId)
                        && info.getDeleted().equals(deleted)).collect(Collectors.toList()));


    }


    @Override
    public void saveOrUpdate(ClassRoutineDto dto) {


        classRoutineRepository.save(classRoutineMapper.map(dto));

    }


}

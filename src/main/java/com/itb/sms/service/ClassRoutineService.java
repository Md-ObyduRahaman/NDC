package com.itb.sms.service;

import com.itb.sms.dto.ClassRoutineDto;
import com.itb.sms.model.UserInfo;

import java.util.List;

public interface ClassRoutineService {


    ClassRoutineDto getById(Long id);

    List<ClassRoutineDto> findRoutineList(UserInfo user, Long classId, Long sectionId, Long sessionId,String deleted);

    void saveOrUpdate(ClassRoutineDto dto);

}

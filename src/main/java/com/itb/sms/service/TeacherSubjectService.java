package com.itb.sms.service;

import com.itb.sms.dto.TeacherSubjectDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface TeacherSubjectService {

    TeacherSubjectDto getById(Long id);

    List<TeacherSubjectDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(TeacherSubjectDto dto);

}

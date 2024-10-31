package com.itb.sms.service;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.FacultyDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface ClassService {

    ClassDto getById(Long id);

    List<ClassDto> findAll(UserInfo user,String status, String deleted);

    void saveOrUpdate(ClassDto dto);

}

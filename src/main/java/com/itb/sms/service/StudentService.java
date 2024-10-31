package com.itb.sms.service;

import com.itb.sms.dto.StudentDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface StudentService {

    StudentDto getById(Long id);

    List<StudentDto> findAll(UserInfo user, String status, String deleted);

    
    Integer saveOrUpdate(StudentDto dto);


}

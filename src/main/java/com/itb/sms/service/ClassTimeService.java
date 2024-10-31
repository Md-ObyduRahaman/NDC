package com.itb.sms.service;

import com.itb.sms.dto.ClassTimeDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface ClassTimeService {

    ClassTimeDto getById(Long id);

    List<ClassTimeDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(ClassTimeDto dto);

}

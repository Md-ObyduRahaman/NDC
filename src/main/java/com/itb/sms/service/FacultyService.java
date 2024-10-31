package com.itb.sms.service;

import com.itb.sms.dto.FacultyDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface FacultyService {

    FacultyDto getById(Long id);

    List<FacultyDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(FacultyDto dto);

}

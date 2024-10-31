package com.itb.sms.service;

import com.itb.sms.dto.SubjectDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SubjectService {

    SubjectDto getById(Long id);

    List<SubjectDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SubjectDto dto);

}

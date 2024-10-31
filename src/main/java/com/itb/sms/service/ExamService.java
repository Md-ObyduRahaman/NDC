package com.itb.sms.service;

import com.itb.sms.dto.ExamDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface ExamService {

    ExamDto getById(Long id);

    List<ExamDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(ExamDto dto);

}

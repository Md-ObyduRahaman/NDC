package com.itb.sms.service;

import com.itb.sms.dto.SubjectBookDto;
import com.itb.sms.dto.SubjectDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SubjectBookService {

    SubjectBookDto getById(Long id);

    List<SubjectBookDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SubjectBookDto dto);

}

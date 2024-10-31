package com.itb.sms.service;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.SectionDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SectionService {

    SectionDto getById(Long id);

    List<SectionDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SectionDto dto);

}

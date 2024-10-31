package com.itb.sms.service;

import com.itb.sms.dto.MajorDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface MajorService {

    MajorDto getById(Long id);

    List<MajorDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(MajorDto dto);

}

package com.itb.sms.service;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.YearDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface YearService {

    YearDto getById(Long id);

    List<YearDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(YearDto dto);

}

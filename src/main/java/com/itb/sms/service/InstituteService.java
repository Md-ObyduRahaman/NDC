package com.itb.sms.service;

import com.itb.sms.dto.InstituteDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface InstituteService {

    InstituteDto getById(Long id);

    List<InstituteDto> findAll();

    void saveOrUpdate(InstituteDto dto);

}

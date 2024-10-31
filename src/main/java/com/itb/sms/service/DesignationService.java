package com.itb.sms.service;

import com.itb.sms.dto.DesignationDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface DesignationService {

    DesignationDto getById(Long id);

    List<DesignationDto> findAll(UserInfo user, String status, String deleted);

    Integer saveOrUpdate(DesignationDto dto);

}

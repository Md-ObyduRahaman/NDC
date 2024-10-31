package com.itb.sms.service;

import com.itb.sms.dto.OccupationDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface OccupationService {

    OccupationDto getById(Long id);

    List<OccupationDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(OccupationDto dto);

}

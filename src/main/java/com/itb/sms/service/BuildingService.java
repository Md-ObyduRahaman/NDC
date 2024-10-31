package com.itb.sms.service;

import com.itb.sms.dto.BuildingDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface BuildingService {

    BuildingDto getById(Long id);

    List<BuildingDto> findAll(UserInfo user,String status, String deleted);

    void saveOrUpdate(BuildingDto dto);

}

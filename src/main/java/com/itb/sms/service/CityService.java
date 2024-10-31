package com.itb.sms.service;

import com.itb.sms.dto.CityDto;

import java.util.List;


public interface CityService {

    CityDto getById(Long id);

    List<CityDto> findAll(String status, String deleted);

    void saveOrUpdate(CityDto dto);

}

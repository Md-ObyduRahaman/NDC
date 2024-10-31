package com.itb.sms.service;

import com.itb.sms.dto.ReligionDto;

import java.util.List;


public interface ReligionService {

    ReligionDto getById(Long id);

    List<ReligionDto> findAll(String status, String deleted);

    void saveOrUpdate(ReligionDto dto);

}

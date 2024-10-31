package com.itb.sms.service;

import com.itb.sms.dto.CountryDto;

import java.util.List;


public interface CountryService {

    CountryDto getById(Long id);

    List<CountryDto> findAll();

    void saveOrUpdate(CountryDto dto);

}

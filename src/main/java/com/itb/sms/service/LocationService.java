package com.itb.sms.service;


import com.itb.sms.dto.LocationDto;

import java.util.List;


public interface LocationService {

    LocationDto getById(Long id);

    List<LocationDto> findAll(String status, String deleted);

    void saveOrUpdate(LocationDto dto);

}

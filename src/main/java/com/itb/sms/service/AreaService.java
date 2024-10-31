package com.itb.sms.service;


import com.itb.sms.dto.AreaDto;

import java.util.List;


public interface AreaService {

    AreaDto getById(Long id);

    List<AreaDto> findAll(String status, String deleted);

    void saveOrUpdate(AreaDto dto);

}

package com.itb.sms.service;

import com.itb.sms.dto.UnionDto;

import java.util.List;


public interface UnionService {

    UnionDto getById(Long id);

    List<UnionDto> findAll(String status, String deleted);

    void saveOrUpdate(UnionDto dto);

}

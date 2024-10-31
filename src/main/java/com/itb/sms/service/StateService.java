package com.itb.sms.service;

import com.itb.sms.dto.StateDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface StateService {

    StateDto getById(Long id);

    List<StateDto> findAll(String status, String deleted);

    void saveOrUpdate(StateDto dto);

}

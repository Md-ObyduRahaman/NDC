package com.itb.sms.service;

import com.itb.sms.dto.SessionDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SessionService {

    SessionDto getById(Long id);

    List<SessionDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SessionDto dto);

}

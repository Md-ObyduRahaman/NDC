package com.itb.sms.service;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.RoomDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface RoomService {

    RoomDto getById(Long id);

    List<RoomDto> findAll(UserInfo user,String status, String deleted);

    void saveOrUpdate(RoomDto dto);

}

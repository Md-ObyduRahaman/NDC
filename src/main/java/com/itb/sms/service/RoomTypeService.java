package com.itb.sms.service;


import com.itb.sms.dto.RoomTypeDto;
import com.itb.sms.dto.SessionDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface RoomTypeService {

    RoomTypeDto getById(Long id);

    List<RoomTypeDto> findAll(UserInfo user, String status, String deleted);



    void saveOrUpdate(RoomTypeDto dto);

}

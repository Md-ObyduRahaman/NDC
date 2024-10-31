package com.itb.sms.service;

import com.itb.sms.dto.OtherInstituteDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface OtherInstituteService {

    OtherInstituteDto getById(Long id);

    List<OtherInstituteDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(OtherInstituteDto dto);

}

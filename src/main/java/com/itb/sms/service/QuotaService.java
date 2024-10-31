package com.itb.sms.service;

import com.itb.sms.dto.QuotaDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface QuotaService {

   QuotaDto getById(Long id);

    List<QuotaDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(QuotaDto dto);

}

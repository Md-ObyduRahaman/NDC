package com.itb.sms.service;


import com.itb.sms.dto.SubjectTypeDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SubjectTypeService {

    SubjectTypeDto getById(Long id);

    List<SubjectTypeDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SubjectTypeDto dto);

}

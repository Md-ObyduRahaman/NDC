package com.itb.sms.service;


import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface ClassTypeService {

    ClassTypeDto getById(Long id);

    List<ClassTypeDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(ClassTypeDto dto);

}

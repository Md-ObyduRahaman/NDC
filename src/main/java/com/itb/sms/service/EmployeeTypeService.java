package com.itb.sms.service;


import com.itb.sms.dto.EmployeeTypeDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface EmployeeTypeService {

    EmployeeTypeDto getById(Long id);

    List<EmployeeTypeDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(EmployeeTypeDto dto);

}

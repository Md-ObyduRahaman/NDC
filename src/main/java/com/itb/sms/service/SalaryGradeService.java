package com.itb.sms.service;


import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.dto.SalaryGradeDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface SalaryGradeService {

    SalaryGradeDto getById(Long id);

    List<SalaryGradeDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(SalaryGradeDto dto);

}

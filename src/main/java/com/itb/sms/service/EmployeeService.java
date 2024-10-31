package com.itb.sms.service;

import com.itb.sms.dto.EmployeeDto;
import com.itb.sms.dto.InstituteDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface EmployeeService {

    EmployeeDto getById(Long id);

    List<EmployeeDto> findAll(UserInfo user, String status, String deleted);

    List<EmployeeDto> findTeachingStaff(UserInfo user, String status, String deleted);

    Integer saveOrUpdate(EmployeeDto dto);

    String  getUdEmployeeCode(Long  instituteId,Long branchId);

}

package com.itb.sms.service;

import com.itb.sms.dto.BranchDto;
import com.itb.sms.dto.InstituteDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface BranchService {

    BranchDto getById(Long id);

    List<BranchDto> findAll(UserInfo user, String status, String deleted);

    Integer saveOrUpdate(BranchDto dto);

}

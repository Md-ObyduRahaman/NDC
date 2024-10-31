package com.itb.sms.service;


import com.itb.sms.dto.GroupDto;
import java.util.List;


public interface GroupService {

    GroupDto getById(Long id);

    List<GroupDto> findAll(String status, String deleted);

    void saveOrUpdate(GroupDto dto);

}

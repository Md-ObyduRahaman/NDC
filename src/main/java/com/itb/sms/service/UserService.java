package com.itb.sms.service;


import com.itb.sms.dto.UserInfoDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface UserService {

    UserInfo getUserById(Long id);

    UserInfo getCurrentUser();

    String getCurrentUserName();

    List<UserInfoDto> findAll(String status);

}

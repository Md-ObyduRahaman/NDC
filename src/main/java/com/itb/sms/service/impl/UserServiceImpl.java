package com.itb.sms.service.impl;

import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.dto.UserInfoDto;
import com.itb.sms.mapper.UserMapper;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.UserRepository;
import com.itb.sms.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserServiceImpl(UserMapper userMapper,UserRepository userRepository) {
        this.userMapper = userMapper ;
        this.userRepository = userRepository;
    }

    @Override
    public UserInfo getUserById(Long id) {

        return userRepository.getById(id);
    }

    @Override
    public UserInfo getCurrentUser() {


        return userRepository.findByUsername(this.getCurrentUserName());

    }

    @Override
    public String getCurrentUserName() {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        //System.out.println("Current UserName"+currentUserName);
        return currentUserName;
    }

    @Override
    public List<UserInfoDto> findAll(String status) {
        if (status != null) {

            return userMapper.mapList(userRepository.findAll().stream()
                    .filter(info -> info.getStatus().equals(status))
                    .collect(Collectors.toList()));
        } else {

            return userMapper.mapList(userRepository.findAll());
        }


    }

}

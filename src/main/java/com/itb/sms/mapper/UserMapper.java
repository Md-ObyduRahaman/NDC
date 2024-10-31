package com.itb.sms.mapper;


import com.itb.sms.dto.UserInfoDto;
import com.itb.sms.model.RoleInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.RoleRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper {

    private final RoleRepository roleRepository;

    public UserMapper(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UserInfo map(UserInfoDto dto) {

        UserInfo entity = new UserInfo();

        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());

        Optional<RoleInfo> roleInfo=roleRepository.findById(dto.getRoleId());
        if(roleInfo.isPresent()){
            entity.setRoleInfo(roleInfo.get());
        }else {

            new Exception("Role is not exist with id " + dto.getRoleId());
        }

        entity.setTypeId(dto.getTypeId());
        entity.setInstituteId(dto.getInstituteId());
        entity.setEmail(dto.getEmail());
        entity.setPhoto(dto.getPhoto());
        entity.setStatus(dto.getStatus());



        return entity;

    }


    public List<UserInfoDto> mapList(List<UserInfo> entities) {
        List<UserInfoDto> list = new ArrayList<>();

        UserInfoDto dto;

        for (UserInfo entity : entities) {

            dto = new UserInfoDto();

            dto.setId(entity.getId());
            dto.setUsername(entity.getUsername());
            dto.setPassword(entity.getPassword());
            dto.setRoleId(entity.getRoleInfo().getId());
            dto.setTypeId(entity.getTypeId());
            dto.setInstituteId(entity.getInstituteId());
            dto.setEmail(entity.getEmail());
            dto.setPhoto(entity.getPhoto());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());
            dto.setStatus(entity.getStatus());

            list.add(dto);
        }

        return list;


    }


    public UserInfoDto map(UserInfo entity) {

        UserInfoDto dto = new UserInfoDto();

        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoleId(entity.getRoleInfo().getId());
        dto.setTypeId(entity.getTypeId());
        dto.setInstituteId(entity.getInstituteId());
        dto.setEmail(entity.getEmail());
        dto.setPhoto(entity.getPhoto());
        dto.setStatus(entity.getStatus());


        return dto;


    }
}

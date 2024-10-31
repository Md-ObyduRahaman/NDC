package com.itb.sms.mapper;


import com.itb.sms.dto.GroupDto;
import com.itb.sms.model.GroupInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupMapper {


    private final UserService userService;

    public GroupMapper(UserService userService) {
        this.userService = userService;
    }


    public GroupInfo map(GroupDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        GroupInfo entity = new GroupInfo();
        entity.setId(dto.getId());
        entity.setGroupName(dto.getGroupName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<GroupDto> mapList(List<GroupInfo> entities) {
        List<GroupDto> list = new ArrayList<>();

        GroupDto dto;

        for (GroupInfo entity : entities) {

            dto = new GroupDto();
            dto.setId(entity.getId());
            dto.setGroupName(entity.getGroupName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());

            list.add(dto);
        }

        return list;


    }


    public GroupDto map(GroupInfo entity) {

        GroupDto dto = new GroupDto();

        dto.setId(entity.getId());
        dto.setGroupName(entity.getGroupName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

package com.itb.sms.mapper;

import com.itb.sms.dto.PostDto;
import com.itb.sms.model.PostInfo;
import com.itb.sms.model.CityInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.CityRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostMapper {


    private final UserService userService;
    private final CityRepository cityRepository;

    public PostMapper(UserService userService, CityRepository cityRepository) {
        this.userService = userService;
        this.cityRepository = cityRepository;
    }


    public PostInfo map(PostDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        PostInfo entity = new PostInfo();
        entity.setId(dto.getId());
        entity.setPostName(dto.getPostName());
        Optional<CityInfo> cityInfo=cityRepository.findById(dto.getCityId());
        if (cityInfo.isPresent()){
            entity.setCityInfo(cityInfo.get());
        }else{
            new Exception("City is not exist with id " + dto.getCityId());
        }

        entity.setDeleted(dto.getDeleted());
        entity.setStatus(dto.getStatus());
        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<PostDto> mapList(List<PostInfo> entities) {
        List<PostDto> list = new ArrayList<>();

        PostDto dto;

        for (PostInfo entity : entities) {

            dto = new PostDto();
            dto.setId(entity.getId());
            dto.setPostName(entity.getPostName());
            dto.setCityId(entity.getCityInfo().getId());
            dto.setCityName(entity.getCityInfo().getCityName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            list.add(dto);
        }

        return list;


    }


    public PostDto map(PostInfo entity) {
        PostDto dto = new PostDto();

        dto.setId(entity.getId());
        dto.setPostName(entity.getPostName());
        dto.setCityId(entity.getCityInfo().getId());
        dto.setCityName(entity.getCityInfo().getCityName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }
}

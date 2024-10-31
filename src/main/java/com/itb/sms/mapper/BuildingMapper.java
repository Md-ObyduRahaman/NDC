package com.itb.sms.mapper;


import com.itb.sms.dto.BuildingDto;
import com.itb.sms.model.BuildingInfo;
import com.itb.sms.model.CityInfo;
import com.itb.sms.model.PostInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.CityRepository;
import com.itb.sms.repository.PostRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BuildingMapper {


    private final UserService userService;
    private final CityRepository cityRepository;
    private final PostRepository postRepository;

    public BuildingMapper(UserService userService, CityRepository cityRepository,PostRepository postRepository) {
        this.userService = userService;
        this.cityRepository = cityRepository;
        this.postRepository = postRepository;
    }


    public BuildingInfo map(BuildingDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        BuildingInfo entity = new BuildingInfo();
        entity.setId(dto.getId());
        entity.setBuildingName(dto.getBuildingName());
        entity.setNoOfRoom(dto.getNoOfRoom());
        entity.setPicture(dto.getPicture());
        Optional<CityInfo> cityInfo=cityRepository.findById(dto.getCityId());
        if(cityInfo.isPresent()){
            entity.setCityInfo(cityInfo.get());
        }else {

                new Exception("City is not exist with id " + dto.getCityId());
            }

        Optional<PostInfo> postInfo=postRepository.findById(dto.getPostId());
        if(postInfo.isPresent()){
            entity.setPostInfo(postInfo.get());
        }else {

            new Exception("Post is not exist with id " + dto.getPostId());
        }
        entity.setAddress(dto.getAddress());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<BuildingDto> mapList(List<BuildingInfo> entities) {
        List<BuildingDto> list = new ArrayList<>();

        BuildingDto dto;

        for (BuildingInfo entity : entities) {

            dto = new BuildingDto();
            dto.setId(entity.getId());
            dto.setBuildingName(entity.getBuildingName());
            dto.setNoOfRoom(entity.getNoOfRoom());
            dto.setAddress(entity.getAddress());
            dto.setPicture(entity.getPicture());
            dto.setCityId(entity.getCityInfo().getId());
            dto.setCityName(entity.getCityInfo().getCityName());
            dto.setPostId(entity.getPostInfo().getId());
            dto.setPostName(entity.getPostInfo().getPostName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public BuildingDto map(BuildingInfo entity) {

        BuildingDto dto = new BuildingDto();

        dto.setId(entity.getId());
        dto.setBuildingName(entity.getBuildingName());
        dto.setNoOfRoom(entity.getNoOfRoom());
        dto.setAddress(entity.getAddress());
        dto.setPicture(entity.getPicture());
        dto.setCityId(entity.getCityInfo().getId());
        dto.setCityName(entity.getCityInfo().getCityName());
        dto.setPostId(entity.getPostInfo().getId());
        dto.setPostName(entity.getPostInfo().getPostName());
        dto.setStatus(entity.getStatus());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());
        dto.setDeleted(entity.getDeleted());


        return dto;


    }
}

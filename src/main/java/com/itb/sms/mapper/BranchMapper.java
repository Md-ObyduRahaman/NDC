package com.itb.sms.mapper;

import com.itb.sms.dto.BranchDto;
import com.itb.sms.model.BranchInfo;
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
public class BranchMapper {


    private final UserService userService;
    private final CityRepository cityRepository;
    private final PostRepository postRepository;

    public BranchMapper(UserService userService,CityRepository cityRepository,PostRepository postRepository) {
        this.userService = userService;
        this.cityRepository = cityRepository ;
        this.postRepository = postRepository ;
    }


    public BranchInfo map(BranchDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        BranchInfo entity = new BranchInfo();
        entity.setId(dto.getId());
        entity.setBranchName(dto.getBranchName());
        entity.setLogo(dto.getLogo());
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
        entity.setAddress1(dto.getAddress1());
        entity.setAddress2(dto.getAddress2());
        entity.setPhoneNumber(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setInstituteId(userInfo.getInstituteId());
        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<BranchDto> mapList(List<BranchInfo> entities) {
        List<BranchDto> list = new ArrayList<>();

        BranchDto dto;

        for (BranchInfo entity : entities) {

            dto = new BranchDto();
            dto.setId(entity.getId());
            dto.setBranchName(entity.getBranchName());
            dto.setLogo(entity.getLogo());
            dto.setAddress1(entity.getAddress1());
            dto.setAddress2(entity.getAddress2());
            dto.setCityId(entity.getCityInfo().getId());
            dto.setCityName(entity.getCityInfo().getCityName());
            dto.setPostId(entity.getPostInfo().getId());
            dto.setPostName(entity.getPostInfo().getPostName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setPhoneNumber(entity.getPhoneNumber());
            dto.setEmail(entity.getEmail());



            list.add(dto);
        }

        return list;


    }


    public BranchDto map(BranchInfo entity) {
        BranchDto dto = new BranchDto();
        dto.setId(entity.getId());
        dto.setBranchName(entity.getBranchName());
        dto.setLogo(entity.getLogo());
        dto.setAddress1(entity.getAddress1());
        dto.setAddress2(entity.getAddress2());
        dto.setCityId(entity.getCityInfo().getId());
        dto.setCityName(entity.getCityInfo().getCityName());
        dto.setPostId(entity.getPostInfo().getId());
        dto.setPostName(entity.getPostInfo().getPostName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setEmail(entity.getEmail());


        return dto;


    }
}

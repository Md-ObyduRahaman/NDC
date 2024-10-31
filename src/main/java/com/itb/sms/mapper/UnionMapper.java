package com.itb.sms.mapper;

import com.itb.sms.dto.PostDto;
import com.itb.sms.dto.UnionDto;
import com.itb.sms.model.PostInfo;
import com.itb.sms.model.PostInfo;
import com.itb.sms.model.UnionInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.PostRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UnionMapper {


    private final UserService userService;
    private final PostRepository postRepository;

    public UnionMapper(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }


    public UnionInfo map(UnionDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        UnionInfo entity = new UnionInfo();
        entity.setId(dto.getId());
        entity.setUnionName(dto.getUnionName());
        Optional<PostInfo> postInfo=postRepository.findById(dto.getPostId());
        if (postInfo.isPresent()){
            entity.setPostInfo(postInfo.get());
        }else{
            new Exception("Post is not exist with id " + dto.getPostId());
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


    public List<UnionDto> mapList(List<UnionInfo> entities) {
        List<UnionDto> list = new ArrayList<>();

        UnionDto dto;

        for (UnionInfo entity : entities) {

            dto = new UnionDto();
            dto.setId(entity.getId());
            dto.setUnionName(entity.getUnionName());
            dto.setPostId(entity.getPostInfo().getId());
            dto.setPostName(entity.getPostInfo().getPostName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            list.add(dto);
        }

        return list;


    }


    public UnionDto map(UnionInfo entity) {
        UnionDto dto = new UnionDto();

        dto.setId(entity.getId());
        dto.setUnionName(entity.getUnionName());
        dto.setPostId(entity.getPostInfo().getId());
        dto.setPostName(entity.getPostInfo().getPostName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }
}

package com.itb.sms.service;

import com.itb.sms.dto.CityDto;
import com.itb.sms.dto.PostDto;

import java.util.List;


public interface PostService {

    PostDto getById(Long id);

    List<PostDto> findAll(String status, String deleted);

    void saveOrUpdate(PostDto dto);

}

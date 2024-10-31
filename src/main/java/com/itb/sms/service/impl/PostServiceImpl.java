package com.itb.sms.service.impl;

import com.itb.sms.dto.PostDto;
import com.itb.sms.mapper.PostMapper;
import com.itb.sms.model.PostInfo;
import com.itb.sms.repository.PostRepository;
import com.itb.sms.service.PostService;
import com.itb.sms.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final PostRepository postRepository;

    public PostServiceImpl(PostMapper postMapper, PostRepository postRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
    }

    @Override
    public PostDto getById(Long id) {
        Optional<PostInfo> entity = postRepository.findById(id);

        return postMapper.map(entity.get());

    }


    @Override
    public List<PostDto> findAll(String status, String deleted) {
        if (status != null) {

            return postMapper.mapList(postRepository.findAll().stream()
                    .filter(info ->info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return postMapper.mapList(postRepository.findAll().stream()
                    .filter(info -> info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(PostDto dto) {


            postRepository.save(postMapper.map(dto));

    }


}

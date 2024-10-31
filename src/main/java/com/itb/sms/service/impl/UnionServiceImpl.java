package com.itb.sms.service.impl;

import com.itb.sms.dto.UnionDto;
import com.itb.sms.mapper.UnionMapper;
import com.itb.sms.model.UnionInfo;
import com.itb.sms.repository.UnionRepository;
import com.itb.sms.service.UnionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnionServiceImpl implements UnionService {

    private final UnionMapper unionMapper;
    private final UnionRepository unionRepository;

    public UnionServiceImpl(UnionMapper unionMapper, UnionRepository unionRepository) {
        this.unionMapper = unionMapper;
        this.unionRepository = unionRepository;
    }

    @Override
    public UnionDto getById(Long id) {
        Optional<UnionInfo> entity = unionRepository.findById(id);

        return unionMapper.map(entity.get());

    }


    @Override
    public List<UnionDto> findAll(String status, String deleted) {
        return unionMapper.mapList(unionRepository.findAll().stream()
                    .filter(info ->(status==null || info.getStatus().equals(status))
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));


    }

    @Override
    public void saveOrUpdate(UnionDto dto) {


            unionRepository.save(unionMapper.map(dto));

    }


}

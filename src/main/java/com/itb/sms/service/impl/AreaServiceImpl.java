package com.itb.sms.service.impl;

import com.itb.sms.dto.AreaDto;
import com.itb.sms.mapper.AreaMapper;
import com.itb.sms.model.AreaInfo;
import com.itb.sms.repository.AreaRepository;
import com.itb.sms.service.AreaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaMapper areaMapper;
    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaMapper areaMapper, AreaRepository areaRepository) {
        this.areaMapper = areaMapper;
        this.areaRepository = areaRepository;
    }

    @Override
    public AreaDto getById(Long id) {
        Optional<AreaInfo> entity = areaRepository.findById(id);

        return areaMapper.map(entity.get());

    }


    @Override
    public List<AreaDto> findAll(String status, String deleted) {


            return areaMapper.mapList(areaRepository.findAll().stream()
                    .filter(info ->(status ==null || info.getStatus().equals(status))
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));


    }

    @Override
    public void saveOrUpdate(AreaDto dto) {


        areaRepository.save(areaMapper.map(dto));

    }


}

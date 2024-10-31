package com.itb.sms.service.impl;

import com.itb.sms.dto.ReligionDto;
import com.itb.sms.mapper.ReligionMapper;
import com.itb.sms.model.ReligionInfo;
import com.itb.sms.repository.ReligionRepository;
import com.itb.sms.service.ReligionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReligionServiceImpl implements ReligionService {

    private final ReligionMapper religionMapper;
    private final ReligionRepository religionRepository;

    public ReligionServiceImpl(ReligionMapper religionMapper, ReligionRepository religionRepository) {
        this.religionMapper = religionMapper;
        this.religionRepository = religionRepository;
    }

    @Override
    public ReligionDto getById(Long id) {
        Optional<ReligionInfo> entity = religionRepository.findById(id);

        return religionMapper.map(entity.get());

    }


    @Override
    public List<ReligionDto> findAll(String status, String deleted) {
        if (status != null) {

            return religionMapper.mapList(religionRepository.findAll().stream()
                    .filter(info -> info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return religionMapper.mapList(religionRepository.findAll().stream()
                    .filter(info -> info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(ReligionDto dto) {


        religionRepository.save(religionMapper.map(dto));

    }


}

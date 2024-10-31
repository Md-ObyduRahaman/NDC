package com.itb.sms.service.impl;

import com.itb.sms.dto.InstituteDto;
import com.itb.sms.mapper.InstituteMapper;
import com.itb.sms.model.InstituteInfo;
import com.itb.sms.repository.InstituteRepository;
import com.itb.sms.service.InstituteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstituteServiceImpl implements InstituteService {

    private final InstituteMapper instituteMapper;
    private final InstituteRepository instituteRepository;

    public InstituteServiceImpl(InstituteMapper instituteMapper, InstituteRepository instituteRepository) {
        this.instituteMapper = instituteMapper;
        this.instituteRepository = instituteRepository;
    }

    @Override
    public InstituteDto getById(Long id) {
        Optional<InstituteInfo> entity = instituteRepository.findById(id);
         return instituteMapper.map(entity.get());

    }


    @Override
    public List<InstituteDto> findAll() {
        return instituteMapper.mapList(instituteRepository.findAll());

    }

    @Override
    public void saveOrUpdate(InstituteDto dto) {


            instituteRepository.save(instituteMapper.map(dto));

    }


}

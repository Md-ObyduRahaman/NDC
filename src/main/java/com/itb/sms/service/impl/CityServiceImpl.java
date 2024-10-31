package com.itb.sms.service.impl;

import com.itb.sms.dto.CityDto;
import com.itb.sms.mapper.CityMapper;
import com.itb.sms.model.CityInfo;
import com.itb.sms.repository.CityRepository;
import com.itb.sms.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityMapper cityMapper;
    private final CityRepository cityRepository;

    public CityServiceImpl(CityMapper cityMapper, CityRepository cityRepository) {
        this.cityMapper = cityMapper;
        this.cityRepository = cityRepository;
    }

    @Override
    public CityDto getById(Long id) {
        Optional<CityInfo> entity = cityRepository.findById(id);

        return cityMapper.map(entity.get());

    }


    @Override
    public List<CityDto> findAll(String status, String deleted) {
        if (status != null) {

            return cityMapper.mapList(cityRepository.findAll().stream()
                    .filter(info ->info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return cityMapper.mapList(cityRepository.findAll().stream()
                    .filter(info -> info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(CityDto dto) {


            cityRepository.save(cityMapper.map(dto));

    }


}

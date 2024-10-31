package com.itb.sms.service.impl;

import com.itb.sms.dto.LocationDto;
import com.itb.sms.mapper.LocationMapper;
import com.itb.sms.model.LocationInfo;
import com.itb.sms.repository.LocationRepository;
import com.itb.sms.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationMapper locationMapper, LocationRepository locationRepository) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationDto getById(Long id) {
        Optional<LocationInfo> entity = locationRepository.findById(id);

        return locationMapper.map(entity.get());

    }


    @Override
    public List<LocationDto> findAll(String status, String deleted) {


            return locationMapper.mapList(locationRepository.findAll().stream()
                    .filter(info ->(status ==null || info.getStatus().equals(status))
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));


    }

    @Override
    public void saveOrUpdate(LocationDto dto) {


        locationRepository.save(locationMapper.map(dto));

    }


}

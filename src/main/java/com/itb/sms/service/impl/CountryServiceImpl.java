package com.itb.sms.service.impl;

import com.itb.sms.dto.CountryDto;
import com.itb.sms.dto.InstituteDto;
import com.itb.sms.mapper.CountryMapper;
import com.itb.sms.mapper.InstituteMapper;
import com.itb.sms.model.CountryInfo;
import com.itb.sms.model.InstituteInfo;
import com.itb.sms.repository.CountryRepository;
import com.itb.sms.repository.InstituteRepository;
import com.itb.sms.service.CountryService;
import com.itb.sms.service.InstituteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository CountryRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository CountryRepository) {
        this.countryMapper = countryMapper;
        this.CountryRepository = CountryRepository;
    }

    @Override
    public CountryDto getById(Long id) {
        Optional<CountryInfo> entity = CountryRepository.findById(id);

        return countryMapper.map(entity.get());

    }


    @Override
    public List<CountryDto> findAll() {
        return countryMapper.mapList(CountryRepository.findAll());

    }

    @Override
    public void saveOrUpdate(CountryDto dto) {


        CountryRepository.save(countryMapper.map(dto));

    }


}

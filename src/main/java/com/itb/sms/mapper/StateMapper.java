package com.itb.sms.mapper;

import com.itb.sms.dto.StateDto;
import com.itb.sms.model.CountryInfo;
import com.itb.sms.model.StateInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.CountryRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StateMapper {


    private final UserService userService;
    private final CountryRepository countryRepository;

    public StateMapper(UserService userService,CountryRepository countryRepository) {
        this.userService = userService;
        this.countryRepository = countryRepository;
    }


    public StateInfo map(StateDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        StateInfo entity = new StateInfo();
        entity.setId(dto.getId());
        entity.setStateName(dto.getStateName());
        Optional<CountryInfo> countryInfo=countryRepository.findById(dto.getCountryId());
        if (countryInfo.isPresent()){
            entity.setCountryInfo(countryInfo.get());
        }else{
            new Exception("Country is not exist with id " + dto.getCountryId());
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


    public List<StateDto> mapList(List<StateInfo> entities) {
        List<StateDto> list = new ArrayList<>();

        StateDto dto;

        for (StateInfo entity : entities) {

            dto = new StateDto();
            dto.setId(entity.getId());
            dto.setStateName(entity.getStateName());
            dto.setCountryId(entity.getCountryInfo().getId());
            dto.setCountryName(entity.getCountryInfo().getCountryName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            list.add(dto);
        }

        return list;


    }


    public StateDto map(StateInfo entity) {
        StateDto dto = new StateDto();

        dto.setId(entity.getId());
        dto.setStateName(entity.getStateName());
        dto.setCountryId(entity.getCountryInfo().getId());
        dto.setCountryName(entity.getCountryInfo().getCountryName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }
}

package com.itb.sms.mapper;

import com.itb.sms.dto.CityDto;
import com.itb.sms.model.CityInfo;
import com.itb.sms.model.StateInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.StateRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CityMapper {


    private final UserService userService;
    private final StateRepository stateRepository;

    public CityMapper(UserService userService, StateRepository stateRepository) {
        this.userService = userService;
        this.stateRepository = stateRepository;
    }


    public CityInfo map(CityDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        CityInfo entity = new CityInfo();
        entity.setId(dto.getId());
        entity.setCityName(dto.getCityName());
        Optional<StateInfo> stateInfo=stateRepository.findById(dto.getStateId());
        if (stateInfo.isPresent()){
            entity.setStateInfo(stateInfo.get());
        }else{
            new Exception("State is not exist with id " + dto.getStateId());
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


    public List<CityDto> mapList(List<CityInfo> entities) {
        List<CityDto> list = new ArrayList<>();

        CityDto dto;

        for (CityInfo entity : entities) {

            dto = new CityDto();
            dto.setId(entity.getId());
            dto.setCityName(entity.getCityName());
            dto.setStateId(entity.getStateInfo().getId());
            dto.setStateName(entity.getStateInfo().getStateName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            list.add(dto);
        }

        return list;


    }


    public CityDto map(CityInfo entity) {
        CityDto dto = new CityDto();

        dto.setId(entity.getId());
        dto.setCityName(entity.getCityName());
        dto.setStateId(entity.getStateInfo().getId());
        dto.setStateName(entity.getStateInfo().getStateName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());

        return dto;


    }
}

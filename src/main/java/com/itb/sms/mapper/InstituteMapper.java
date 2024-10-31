package com.itb.sms.mapper;

import com.itb.sms.dto.InstituteDto;
import com.itb.sms.model.CountryInfo;
import com.itb.sms.model.InstituteInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.CountryRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InstituteMapper {


    private final UserService userService;
    private final CountryRepository countryRepository;

    public InstituteMapper(UserService userService,CountryRepository countryRepository) {
        this.userService = userService;
        this.countryRepository = countryRepository;
    }


    public InstituteInfo map(InstituteDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        InstituteInfo entity = new InstituteInfo();
        entity.setId(dto.getId());
        entity.setInstituteName(dto.getInstituteName());
        entity.setLogo(dto.getLogo());
        entity.setStatus(dto.getStatus());
        Optional<CountryInfo> moduleInfo = countryRepository.findById(dto.getCountryId());
        if (moduleInfo.isPresent()) {
            entity.setCountryInfo(moduleInfo.get());
        } else {

            new Exception("Country is not exist with id " + dto.getCountryId());
        }
        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<InstituteDto> mapList(List<InstituteInfo> entities) {
        List<InstituteDto> list = new ArrayList<>();

        InstituteDto dto;

        for (InstituteInfo entity : entities) {

            dto = new InstituteDto();
            dto.setId(entity.getId());
            dto.setInstituteName(entity.getInstituteName());
            dto.setLogo(entity.getLogo());
            dto.setStatus(entity.getStatus());
            dto.setCountryId(entity.getCountryInfo().getId());
            dto.setCountryName(entity.getCountryInfo().getCountryName());


            list.add(dto);
        }

        return list;


    }


    public InstituteDto map(InstituteInfo entity) {

        InstituteDto dto = new InstituteDto();

        dto.setId(entity.getId());
        dto.setInstituteName(entity.getInstituteName());
        dto.setLogo(entity.getLogo());
        dto.setStatus(entity.getStatus());
        dto.setCountryId(entity.getCountryInfo().getId());
        dto.setCountryName(entity.getCountryInfo().getCountryName());

        return dto;


    }
}

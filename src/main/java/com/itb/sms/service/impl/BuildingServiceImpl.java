package com.itb.sms.service.impl;

import com.itb.sms.dto.BuildingDto;
import com.itb.sms.mapper.BuildingMapper;
import com.itb.sms.model.BuildingInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.BuildingRepository;
import com.itb.sms.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingMapper buildingMapper;
    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingMapper buildingMapper, BuildingRepository buildingRepository) {
        this.buildingMapper = buildingMapper;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public BuildingDto getById(Long id) {
        Optional<BuildingInfo> entity = buildingRepository.findById(id);

        return buildingMapper.map(entity.get());

    }


    @Override
    public List<BuildingDto> findAll(UserInfo user,String status, String deleted) {
        if (status != null) {

            return buildingMapper.mapList(buildingRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return buildingMapper.mapList(buildingRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(BuildingDto dto) {


            buildingRepository.save(buildingMapper.map(dto));

    }


}

package com.itb.sms.service.impl;

import com.itb.sms.dto.OccupationDto;
import com.itb.sms.mapper.OccupationMapper;
import com.itb.sms.model.OccupationInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.OccupationRepository;
import com.itb.sms.service.OccupationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OccupationServiceImpl implements OccupationService {

    private final OccupationMapper occupationMapper;
    private final OccupationRepository occupationRepository;

    public OccupationServiceImpl(OccupationMapper occupationMapper, OccupationRepository occupationRepository) {
        this.occupationMapper = occupationMapper;
        this.occupationRepository = occupationRepository;
    }

    @Override
    public OccupationDto getById(Long id) {
        Optional<OccupationInfo> entity = occupationRepository.findById(id);

        return occupationMapper.map(entity.get());

    }


    @Override
    public List<OccupationDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return occupationMapper.mapList(occupationRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return occupationMapper.mapList(occupationRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(OccupationDto dto) {


            occupationRepository.save(occupationMapper.map(dto));

    }


}

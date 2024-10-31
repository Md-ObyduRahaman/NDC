package com.itb.sms.service.impl;

import com.itb.sms.dto.DesignationDto;
import com.itb.sms.mapper.DesignationMapper;
import com.itb.sms.model.DesignationInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.DesignationRepository;
import com.itb.sms.service.DesignationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DesignationServiceImpl implements DesignationService {

    private final DesignationMapper designationMapper;
    private final DesignationRepository designationRepository;

    public DesignationServiceImpl(DesignationMapper designationMapper, DesignationRepository designationRepository) {
        this.designationMapper = designationMapper;
        this.designationRepository = designationRepository;
    }

    @Override
    public DesignationDto getById(Long id) {
        Optional<DesignationInfo> entity = designationRepository.findById(id);

        return designationMapper.map(entity.get());

    }


    @Override
    public List<DesignationDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return designationMapper.mapList(designationRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return designationMapper.mapList(designationRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public Integer saveOrUpdate(DesignationDto dto) {

        try {
            designationRepository.save(designationMapper.map(dto));
            return 1;
        } catch (Exception ex) {

            return -1;
        }
    }


}

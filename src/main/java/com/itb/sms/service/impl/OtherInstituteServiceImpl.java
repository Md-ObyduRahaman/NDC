package com.itb.sms.service.impl;

import com.itb.sms.dto.OtherInstituteDto;
import com.itb.sms.mapper.OtherInstituteMapper;
import com.itb.sms.model.OtherInstituteInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.OtherInstituteRepository;
import com.itb.sms.service.OtherInstituteService;
import com.itb.sms.service.OtherInstituteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtherInstituteServiceImpl implements OtherInstituteService {

    private final OtherInstituteMapper otherInstituteMapper;
    private final OtherInstituteRepository otherInstituteRepository;

    public OtherInstituteServiceImpl(OtherInstituteMapper otherInstituteMapper, OtherInstituteRepository otherInstituteRepository) {
        this.otherInstituteMapper = otherInstituteMapper;
        this.otherInstituteRepository = otherInstituteRepository;
    }

    @Override
    public OtherInstituteDto getById(Long id) {
        Optional<OtherInstituteInfo> entity = otherInstituteRepository.findById(id);

        return otherInstituteMapper.map(entity.get());

    }


    @Override
    public List<OtherInstituteDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return otherInstituteMapper.mapList(otherInstituteRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return otherInstituteMapper.mapList(otherInstituteRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(OtherInstituteDto dto) {


            otherInstituteRepository.save(otherInstituteMapper.map(dto));

    }


}

package com.itb.sms.service.impl;

import com.itb.sms.dto.MajorDto;
import com.itb.sms.mapper.MajorMapper;
import com.itb.sms.model.MajorInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.MajorRepository;
import com.itb.sms.service.MajorService;
import com.itb.sms.service.MajorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MajorServiceImpl implements MajorService {

    private final MajorMapper majorMapper;
    private final MajorRepository majorRepository;

    public MajorServiceImpl(MajorMapper majorMapper, MajorRepository majorRepository) {
        this.majorMapper = majorMapper;
        this.majorRepository = majorRepository;
    }

    @Override
    public MajorDto getById(Long id) {
        Optional<MajorInfo> entity = majorRepository.findById(id);

        return majorMapper.map(entity.get());

    }


    @Override
    public List<MajorDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return majorMapper.mapList(majorRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return majorMapper.mapList(majorRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(MajorDto dto) {


            majorRepository.save(majorMapper.map(dto));

    }


}

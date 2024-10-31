package com.itb.sms.service.impl;

import com.itb.sms.dto.SectionDto;
import com.itb.sms.mapper.SectionMapper;
import com.itb.sms.model.SectionInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SectionRepository;
import com.itb.sms.service.SectionService;
import com.itb.sms.service.SectionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SectionServiceImpl implements SectionService {

    private final SectionMapper sectionMapper;
    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionMapper sectionMapper, SectionRepository sectionRepository) {
        this.sectionMapper = sectionMapper;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public SectionDto getById(Long id) {
        Optional<SectionInfo> entity = sectionRepository.findById(id);

        return sectionMapper.map(entity.get());

    }


    @Override
    public List<SectionDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return sectionMapper.mapList(sectionRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                                    && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return sectionMapper.mapList(sectionRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                                    && info.getBranchId().equals(user.getBranchId())
                            && info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(SectionDto dto) {


            sectionRepository.save(sectionMapper.map(dto));

    }


}

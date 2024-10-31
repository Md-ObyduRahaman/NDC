package com.itb.sms.service.impl;

import com.itb.sms.dto.SubjectTypeDto;
import com.itb.sms.mapper.SubjectTypeMapper;
import com.itb.sms.model.SubjectTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SubjectTypeRepository;
import com.itb.sms.service.SubjectTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectTypeServiceImpl implements SubjectTypeService {

    private final SubjectTypeMapper subjectTypeMapper;
    private final SubjectTypeRepository subjectTypeRepository;

    public SubjectTypeServiceImpl(SubjectTypeMapper subjectTypeMapper, SubjectTypeRepository subjectTypeRepository) {
        this.subjectTypeMapper = subjectTypeMapper;
        this.subjectTypeRepository = subjectTypeRepository;
    }

    @Override
    public SubjectTypeDto getById(Long id) {
        Optional<SubjectTypeInfo> entity = subjectTypeRepository.findById(id);

        return subjectTypeMapper.map(entity.get());

    }


    @Override
    public List<SubjectTypeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return subjectTypeMapper.mapList(subjectTypeRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return subjectTypeMapper.mapList(subjectTypeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(SubjectTypeDto dto) {


            subjectTypeRepository.save(subjectTypeMapper.map(dto));

    }


}

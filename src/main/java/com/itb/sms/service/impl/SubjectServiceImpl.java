package com.itb.sms.service.impl;

import com.itb.sms.dto.SubjectDto;
import com.itb.sms.mapper.SubjectMapper;
import com.itb.sms.model.SubjectInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SubjectRepository;
import com.itb.sms.service.SubjectService;
import com.itb.sms.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectMapper subjectMapper;
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectMapper subjectMapper, SubjectRepository subjectRepository) {
        this.subjectMapper = subjectMapper;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public SubjectDto getById(Long id) {
        Optional<SubjectInfo> entity = subjectRepository.findById(id);

        return subjectMapper.map(entity.get());

    }


    @Override
    public List<SubjectDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return subjectMapper.mapList(subjectRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return subjectMapper.mapList(subjectRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }


    @Override
    public void saveOrUpdate(SubjectDto dto) {


            subjectRepository.save(subjectMapper.map(dto));

    }


}

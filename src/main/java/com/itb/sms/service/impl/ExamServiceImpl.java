package com.itb.sms.service.impl;

import com.itb.sms.dto.ExamDto;
import com.itb.sms.mapper.ExamMapper;
import com.itb.sms.model.ExamInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ExamRepository;
import com.itb.sms.service.ExamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamMapper examMapper;
    private final ExamRepository examRepository;

    public ExamServiceImpl(ExamMapper examMapper, ExamRepository examRepository) {
        this.examMapper = examMapper;
        this.examRepository = examRepository;
    }

    @Override
    public ExamDto getById(Long id) {
        Optional<ExamInfo> entity = examRepository.findById(id);

        return examMapper.map(entity.get());

    }


    @Override
    public List<ExamDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return examMapper.mapList(examRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return examMapper.mapList(examRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(ExamDto dto) {


            examRepository.save(examMapper.map(dto));

    }


}

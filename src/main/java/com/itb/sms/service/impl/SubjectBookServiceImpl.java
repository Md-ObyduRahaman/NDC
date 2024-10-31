package com.itb.sms.service.impl;

import com.itb.sms.dto.SubjectBookDto;
import com.itb.sms.mapper.SubjectBookMapper;
import com.itb.sms.model.SubjectBookInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SubjectBookRepository;
import com.itb.sms.service.SubjectBookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectBookServiceImpl implements SubjectBookService {

    private final SubjectBookMapper subjectBookMapper;
    private final SubjectBookRepository subjectBookRepository;

    public SubjectBookServiceImpl(SubjectBookMapper subjectBookMapper, SubjectBookRepository subjectBookRepository) {
        this.subjectBookMapper = subjectBookMapper;
        this.subjectBookRepository = subjectBookRepository;
    }

    @Override
    public SubjectBookDto getById(Long id) {
        Optional<SubjectBookInfo> entity = subjectBookRepository.findById(id);

        return subjectBookMapper.map(entity.get());

    }


    @Override
    public List<SubjectBookDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return subjectBookMapper.mapList(subjectBookRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return subjectBookMapper.mapList(subjectBookRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }


    @Override
    public void saveOrUpdate(SubjectBookDto dto) {



            subjectBookRepository.save(subjectBookMapper.map(dto));

    }


}

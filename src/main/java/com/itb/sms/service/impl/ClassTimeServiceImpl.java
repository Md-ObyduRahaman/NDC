package com.itb.sms.service.impl;

import com.itb.sms.dto.ClassTimeDto;
import com.itb.sms.mapper.ClassTimeMapper;
import com.itb.sms.model.ClassTimeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ClassTimeRepository;
import com.itb.sms.service.ClassTimeService;
import com.itb.sms.service.ClassTimeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassTimeServiceImpl implements ClassTimeService {

    private final ClassTimeMapper classTimeMapper;
    private final ClassTimeRepository classTimeRepository;

    public ClassTimeServiceImpl(ClassTimeMapper classTimeMapper, ClassTimeRepository classTimeRepository) {
        this.classTimeMapper = classTimeMapper;
        this.classTimeRepository = classTimeRepository;
    }

    @Override
    public ClassTimeDto getById(Long id) {
        Optional<ClassTimeInfo> entity = classTimeRepository.findById(id);

        return classTimeMapper.map(entity.get());

    }


    @Override
    public List<ClassTimeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return classTimeMapper.mapList(classTimeRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return classTimeMapper.mapList(classTimeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(ClassTimeDto dto) {


            classTimeRepository.save(classTimeMapper.map(dto));

    }


}

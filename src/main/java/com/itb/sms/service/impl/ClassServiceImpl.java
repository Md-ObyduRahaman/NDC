package com.itb.sms.service.impl;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.mapper.ClassMapper;
import com.itb.sms.model.ClassInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ClassRepository;
import com.itb.sms.service.ClassService;
import com.itb.sms.service.ClassService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassMapper classMapper;
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassMapper classMapper, ClassRepository classRepository) {
        this.classMapper = classMapper;
        this.classRepository = classRepository;
    }

    @Override
    public ClassDto getById(Long id) {
        Optional<ClassInfo> entity = classRepository.findById(id);

        return classMapper.map(entity.get());

    }


    @Override
    public List<ClassDto> findAll(UserInfo user,String status, String deleted) {
        if (status != null) {

            return classMapper.mapList(classRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return classMapper.mapList(classRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(ClassDto dto) {


            classRepository.save(classMapper.map(dto));

    }


}

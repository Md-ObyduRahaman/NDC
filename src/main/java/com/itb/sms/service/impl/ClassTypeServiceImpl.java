package com.itb.sms.service.impl;

import com.itb.sms.dto.ClassTypeDto;
import com.itb.sms.mapper.ClassTypeMapper;
import com.itb.sms.model.ClassTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.ClassTypeRepository;
import com.itb.sms.service.ClassTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClassTypeServiceImpl implements ClassTypeService {

    private final ClassTypeMapper classTypeMapper;
    private final ClassTypeRepository classTypeRepository;

    public ClassTypeServiceImpl(ClassTypeMapper classTypeMapper, ClassTypeRepository classTypeRepository) {
        this.classTypeMapper = classTypeMapper;
        this.classTypeRepository = classTypeRepository;
    }

    @Override
    public ClassTypeDto getById(Long id) {
        Optional<ClassTypeInfo> entity = classTypeRepository.findById(id);

        return classTypeMapper.map(entity.get());

    }


    @Override
    public List<ClassTypeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return classTypeMapper.mapList(classTypeRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return classTypeMapper.mapList(classTypeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(ClassTypeDto dto) {


        classTypeRepository.save(classTypeMapper.map(dto));

    }


}

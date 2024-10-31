package com.itb.sms.service.impl;

import com.itb.sms.dto.EmployeeTypeDto;
import com.itb.sms.dto.FacultyDto;
import com.itb.sms.mapper.EmployeeTypeMapper;
import com.itb.sms.model.EmployeeTypeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.EmployeeTypeRepository;
import com.itb.sms.service.EmployeeTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    private final EmployeeTypeMapper employeeTypeMapper;
    private final EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeServiceImpl(EmployeeTypeMapper employeeTypeMapper, EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeMapper = employeeTypeMapper;
        this.employeeTypeRepository = employeeTypeRepository;
    }

    @Override
    public EmployeeTypeDto getById(Long id) {
        Optional<EmployeeTypeInfo> entity = employeeTypeRepository.findById(id);

        return employeeTypeMapper.map(entity.get());

    }


    @Override
    public List<EmployeeTypeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return employeeTypeMapper.mapList(employeeTypeRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return employeeTypeMapper.mapList(employeeTypeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(EmployeeTypeDto dto) {


        employeeTypeRepository.save(employeeTypeMapper.map(dto));

    }


}

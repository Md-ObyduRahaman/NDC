package com.itb.sms.service.impl;

import com.itb.sms.dto.EmployeeDto;
import com.itb.sms.mapper.EmployeeMapper;
import com.itb.sms.model.EmployeeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.EmployeeRepository;
import com.itb.sms.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto getById(Long id) {
        Optional<EmployeeInfo> entity = employeeRepository.findById(id);

        return employeeMapper.map(entity.get());

    }


    @Override
    public List<EmployeeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return employeeMapper.mapList(employeeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .sorted(Comparator.comparing(m -> m.getOrderNo()))
                    .collect(Collectors.toList()));
        } else {

            return employeeMapper.mapList(employeeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getDeleted().equals(deleted))
                    .sorted(Comparator.comparing(m -> m.getOrderNo()))
                    .collect(Collectors.toList()));
        }

    }

    @Override
    public List<EmployeeDto> findTeachingStaff(UserInfo user, String status, String deleted) {


            return employeeMapper.mapList(employeeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted)
                            && info.getTeachingStatus().equals("Y"))
                    .sorted(Comparator.comparing(m -> m.getOrderNo()))
                    .collect(Collectors.toList()));


    }

    @Override
    public Integer saveOrUpdate(EmployeeDto dto) {

        try {
            employeeRepository.save(employeeMapper.map(dto));
            return 1;
        } catch (Exception ex) {

            return -1;
        }
    }

    @Override
    public String getUdEmployeeCode(Long instituteId, Long branchId) {

        return employeeRepository.getUdEmployeeCode(instituteId, branchId);

    }


}

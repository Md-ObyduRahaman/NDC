package com.itb.sms.service.impl;

import com.itb.sms.dto.SalaryGradeDto;
import com.itb.sms.mapper.SalaryGradeMapper;
import com.itb.sms.model.SalaryGradeInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SalaryGradeRepository;
import com.itb.sms.service.SalaryGradeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalaryGradeServiceImpl implements SalaryGradeService {

    private final SalaryGradeMapper salaryGradeMapper;
    private final SalaryGradeRepository salaryGradeRepository;

    public SalaryGradeServiceImpl(SalaryGradeMapper salaryGradeMapper, SalaryGradeRepository salaryGradeRepository) {
        this.salaryGradeMapper = salaryGradeMapper;
        this.salaryGradeRepository = salaryGradeRepository;
    }

    @Override
    public SalaryGradeDto getById(Long id) {
        Optional<SalaryGradeInfo> entity = salaryGradeRepository.findById(id);

        return salaryGradeMapper.map(entity.get());

    }


    @Override
    public List<SalaryGradeDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return salaryGradeMapper.mapList(salaryGradeRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return salaryGradeMapper.mapList(salaryGradeRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(SalaryGradeDto dto) {


        salaryGradeRepository.save(salaryGradeMapper.map(dto));

    }


}

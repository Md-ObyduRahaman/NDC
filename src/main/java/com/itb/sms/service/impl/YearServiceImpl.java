package com.itb.sms.service.impl;

import com.itb.sms.dto.ClassDto;
import com.itb.sms.dto.YearDto;
import com.itb.sms.mapper.YearMapper;
import com.itb.sms.model.UserInfo;
import com.itb.sms.model.YearInfo;
import com.itb.sms.repository.YearRepository;
import com.itb.sms.service.YearService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class YearServiceImpl implements YearService {

    private final YearMapper yearMapper;
    private final YearRepository yearRepository;

    public YearServiceImpl(YearMapper yearMapper, YearRepository yearRepository) {
        this.yearMapper = yearMapper;
        this.yearRepository = yearRepository;
    }

    @Override
    public YearDto getById(Long id) {
        Optional<YearInfo> entity = yearRepository.findById(id);

        return yearMapper.map(entity.get());

    }


    @Override
    public List<YearDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return yearMapper.mapList(yearRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return yearMapper.mapList(yearRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(YearDto dto) {


            yearRepository.save(yearMapper.map(dto));

    }


}

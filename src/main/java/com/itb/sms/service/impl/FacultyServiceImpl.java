package com.itb.sms.service.impl;

import com.itb.sms.dto.FacultyDto;
import com.itb.sms.dto.YearDto;
import com.itb.sms.mapper.FacultyMapper;
import com.itb.sms.model.FacultyInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.FacultyRepository;
import com.itb.sms.service.FacultyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyMapper facultyMapper;
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyMapper facultyMapper, FacultyRepository facultyRepository) {
        this.facultyMapper = facultyMapper;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public FacultyDto getById(Long id) {
        Optional<FacultyInfo> entity = facultyRepository.findById(id);

        return facultyMapper.map(entity.get());

    }


    @Override
    public List<FacultyDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return facultyMapper.mapList(facultyRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return facultyMapper.mapList(facultyRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(FacultyDto dto) {


            facultyRepository.save(facultyMapper.map(dto));

    }


}

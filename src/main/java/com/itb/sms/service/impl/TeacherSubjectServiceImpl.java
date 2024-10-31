package com.itb.sms.service.impl;

import com.itb.sms.dto.TeacherSubjectDto;
import com.itb.sms.mapper.TeacherSubjectMapper;
import com.itb.sms.model.TeacherSubjectInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SubjectBookRepository;
import com.itb.sms.repository.TeacherSubjectRepository;
import com.itb.sms.service.SubjectBookService;
import com.itb.sms.service.TeacherSubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherSubjectServiceImpl implements TeacherSubjectService {

    private final TeacherSubjectMapper teacherSubjectMapper;
    private final TeacherSubjectRepository teacherSubjectRepository;

    public TeacherSubjectServiceImpl(TeacherSubjectMapper teacherSubjectMapper, TeacherSubjectRepository teacherSubjectRepository) {
        this.teacherSubjectMapper = teacherSubjectMapper;
        this.teacherSubjectRepository = teacherSubjectRepository;
    }

    @Override
    public TeacherSubjectDto getById(Long id) {
        Optional<TeacherSubjectInfo> entity = teacherSubjectRepository.findById(id);

        return teacherSubjectMapper.map(entity.get());

    }


    @Override
    public List<TeacherSubjectDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return teacherSubjectMapper.mapList(teacherSubjectRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return teacherSubjectMapper.mapList(teacherSubjectRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }


    @Override
    public void saveOrUpdate(TeacherSubjectDto dto) {



            teacherSubjectRepository.save(teacherSubjectMapper.map(dto));

    }


}

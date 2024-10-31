package com.itb.sms.service.impl;

import com.itb.sms.dto.FacultyDto;
import com.itb.sms.dto.SessionDto;
import com.itb.sms.mapper.SessionMapper;
import com.itb.sms.model.SessionInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.SessionRepository;
import com.itb.sms.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessionServiceImpl implements SessionService {

    private final SessionMapper sessionMapper;
    private final SessionRepository sessionRepository;

    public SessionServiceImpl(SessionMapper sessionMapper, SessionRepository sessionRepository) {
        this.sessionMapper = sessionMapper;
        this.sessionRepository = sessionRepository;
    }

    @Override
    public SessionDto getById(Long id) {
        Optional<SessionInfo> entity = sessionRepository.findById(id);

        return sessionMapper.map(entity.get());

    }


    @Override
    public List<SessionDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return sessionMapper.mapList(sessionRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return sessionMapper.mapList(sessionRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(SessionDto dto) {


            sessionRepository.save(sessionMapper.map(dto));

    }


}

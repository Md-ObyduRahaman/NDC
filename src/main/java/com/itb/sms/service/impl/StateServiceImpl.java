package com.itb.sms.service.impl;

import com.itb.sms.dto.StateDto;
import com.itb.sms.mapper.StateMapper;
import com.itb.sms.model.StateInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.StateRepository;
import com.itb.sms.service.StateService;
import com.itb.sms.service.StateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StateServiceImpl implements StateService {

    private final StateMapper stateMapper;
    private final StateRepository stateRepository;

    public StateServiceImpl(StateMapper stateMapper, StateRepository stateRepository) {
        this.stateMapper = stateMapper;
        this.stateRepository = stateRepository;
    }

    @Override
    public StateDto getById(Long id) {
        Optional<StateInfo> entity = stateRepository.findById(id);

        return stateMapper.map(entity.get());

    }


    @Override
    public List<StateDto> findAll(String status, String deleted) {
        if (status != null) {

            return stateMapper.mapList(stateRepository.findAll().stream()
                    .filter(info ->info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return stateMapper.mapList(stateRepository.findAll().stream()
                    .filter(info -> info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(StateDto dto) {


            stateRepository.save(stateMapper.map(dto));

    }


}

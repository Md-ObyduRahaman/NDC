package com.itb.sms.service.impl;


import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.mapper.ModuleMapper;
import com.itb.sms.repository.ModuleRepository;
import com.itb.sms.service.ModuleService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuleServiceImpl implements ModuleService {

    final
    ModuleRepository moduleRepository;

    final
    ModuleMapper moduleMapper;

    public ModuleServiceImpl(ModuleRepository moduleRepository, ModuleMapper moduleMapper) {
        this.moduleRepository = moduleRepository;
        this.moduleMapper = moduleMapper;
    }


    @Override
    public ModuleInfoDto getModuleById(Long id) {

        try {
            return moduleMapper.map(moduleRepository.getById(id));
        } catch (Exception ex) {
            return null;
        }
    }


    @Override
    public List<ModuleInfoDto> getModules(String status) {
        if (status != null) {

            return moduleMapper.mapList(moduleRepository.findAll().stream()
                    .filter(info -> info.getStatus().equals(status))
                   .sorted(Comparator.comparing(m -> m.getOrderNo()))
                    .collect(Collectors.toList()));
        } else {

            return moduleMapper.mapList(moduleRepository.findAll());
        }


    }

    @Override
    public List<ModuleInfoDto> getModulesByRoleId(Long roleId) {

        return moduleMapper.mapList(moduleRepository.findModuleByRoleId(roleId).stream()
                .sorted(Comparator.comparing(m -> m.getOrderNo()))
                .collect(Collectors.toList()));



    }

    @Override
    public void saveOrUpdate(ModuleInfoDto moduleInfoDto) {


            moduleRepository.save(moduleMapper.map(moduleInfoDto));

    }


}

package com.itb.sms.service.impl;

import com.itb.sms.dto.RoleDto;
import com.itb.sms.mapper.RoleMapper;
import com.itb.sms.model.RoleInfo;
import com.itb.sms.repository.RoleRepository;
import com.itb.sms.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepository) {
        this.roleMapper = roleMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto getById(Long id) {
        Optional<RoleInfo> entity = roleRepository.findById(id);

        return roleMapper.map(entity.get());

    }


    @Override
    public List<RoleDto> findAll(String superAdminStatus) {
        if (superAdminStatus!=null){
            return roleMapper.mapList(roleRepository.findAll().stream()
                    .filter(roleInfo -> roleInfo.getSuperAdminStatus().equals(superAdminStatus)).collect(Collectors.toList()));
        }else{
            return roleMapper.mapList(roleRepository.findAll());
        }


    }

    @Override
    public void saveOrUpdate(RoleDto dto) {


            roleRepository.save(roleMapper.map(dto));

    }


}

package com.itb.sms.service.impl;


import com.itb.sms.dto.RoleMenuInfoDto;
import com.itb.sms.mapper.RoleMenuMapper;
import com.itb.sms.repository.RoleMenuRepository;
import com.itb.sms.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleMenuServiceImpl implements RoleMenuService {


    private final RoleMenuRepository roleMenuRepository;
    private final RoleMenuMapper roleMenuMapper;

    public RoleMenuServiceImpl(RoleMenuMapper roleMenuMapper,RoleMenuRepository roleMenuRepository) {
        this.roleMenuMapper = roleMenuMapper;
        this.roleMenuRepository = roleMenuRepository;
    }


    @Override
    public void saveRoleMenu(RoleMenuInfoDto dto) {

            roleMenuRepository.save(roleMenuMapper.map(dto));

    }

    @Override
    public List<RoleMenuInfoDto> getAssignedMenus(Long roleId) {


        return roleMenuMapper.mapList(roleMenuRepository.findAssignedMenus(roleId));


    }
    @Override
    public void removeRoleMenu(Long menuId, Long roleId){

        roleMenuRepository.removeRoleMenu(menuId,roleId);


    }




}

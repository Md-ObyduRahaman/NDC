package com.itb.sms.service.impl;

import com.itb.sms.dto.MenuInfoDto;
import com.itb.sms.dto.ModuleInfoDto;
import com.itb.sms.mapper.MenuMapper;
import com.itb.sms.model.MenuEntity;
import com.itb.sms.model.MenuInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.MenuNewRepository;
import com.itb.sms.repository.MenuRepository;
import com.itb.sms.repository.UserRepository;
import com.itb.sms.service.MenuService;
import com.itb.sms.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuMapper menuMapper;
    private final MenuRepository menuRepository;
    private final MenuNewRepository menuNewRepository;

    public MenuServiceImpl(MenuMapper menuMapper,MenuRepository menuRepository,MenuNewRepository menuNewRepository) {
        this.menuRepository = menuRepository;
        this.menuMapper = menuMapper ;
        this.menuNewRepository = menuNewRepository ;
    }

    @Override
    public List<MenuInfo> getParentMenuByRoleId(Long roleId) {

            return menuRepository.findParentMenuByRoleId(roleId);

    }

    @Override
    public List<MenuInfo> getChildMenuByRoleId(Long roleId) {

        return menuRepository.findChildMenuByRoleId(roleId);

    }

    @Override
    public MenuInfoDto getMenuById(Long id) {

        try {
            return menuMapper.map(menuNewRepository.getById(id));
        } catch (Exception ex) {
            return null;
        }
    }


    @Override
    public List<MenuInfoDto> findAll(String status) {
        if (status != null) {

            return menuMapper.mapList(menuNewRepository.findAll().stream()
                    .filter(info -> info.getStatus().equals(status))
                    .sorted(Comparator.comparing(m -> m.getOrderNo()))
                    .collect(Collectors.toList()));
        } else {

            return menuMapper.mapList(menuNewRepository.findAll());
        }


    }
    @Override
    public List<MenuInfoDto> getUnAssignedMenus(Long roleId) {

        Comparator<MenuEntity> compareByModuleOrderNo = Comparator.comparing(c -> c.getModuleInfo().getOrderNo());
        Comparator<MenuEntity> compareByMenuOrderNo = Comparator.comparing(c -> c.getOrderNo());
        Comparator<MenuEntity> comparator = compareByModuleOrderNo.thenComparing(compareByMenuOrderNo);
        return menuMapper.mapList(menuNewRepository.findUnAssignedMenus(roleId).stream().sorted(comparator).collect(Collectors.toList()));


    }

    @Override
    public void saveOrUpdate(MenuInfoDto dto) {


        menuNewRepository.save(menuMapper.map(dto));

    }



}

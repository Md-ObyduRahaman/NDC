package com.itb.sms.service;


import com.itb.sms.dto.RoleMenuInfoDto;

import java.util.List;

public interface RoleMenuService {

    List<RoleMenuInfoDto> getAssignedMenus(Long userId);
    void saveRoleMenu(RoleMenuInfoDto dto);
    void removeRoleMenu(Long menuId, Long userId);
}

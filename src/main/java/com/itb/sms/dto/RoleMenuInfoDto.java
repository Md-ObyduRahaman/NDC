package com.itb.sms.dto;

import lombok.Data;

@Data
public class RoleMenuInfoDto {

    private Long id;
    private Long roleId;
    private String roleName;
    private Long menuId;
    private String menuName;
    private String url;
    private Long moduleId;
    private String moduleName;
    private String createStatus;
    private String readStatus;
    private String updateStatus;
    private String deleteStatus;

}

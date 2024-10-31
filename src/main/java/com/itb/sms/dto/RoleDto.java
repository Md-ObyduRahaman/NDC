package com.itb.sms.dto;

import lombok.Data;

@Data
public class RoleDto {

    private Long id;
    private String roleCode;
    private String roleName;
    private String defaultStatus="N";
    private String superAdminStatus="N";
    private String status;



}

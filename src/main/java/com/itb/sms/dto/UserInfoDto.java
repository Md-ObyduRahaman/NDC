package com.itb.sms.dto;

import lombok.Data;

@Data
public class UserInfoDto {

    private Long id;
    private String username;
    private String password;
    private Long roleId;
    private String email;
    private String photo;
    private String status;
    private Long typeId;
    private Long instituteId;
    private Long branchId;


}

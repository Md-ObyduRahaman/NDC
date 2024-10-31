package com.itb.sms.dto;

import lombok.Data;

@Data
public class MenuInfoDto {

    private Long id;
    private String menuName;
    private Long moduleId;
    private String moduleName;
    private Integer orderNo;
    private String url;
    private String status;
}

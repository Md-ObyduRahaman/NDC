package com.itb.sms.dto;

import lombok.Data;

@Data
public class ModuleInfoDto {

    private Long id;
    private String moduleName;
    private String icon;
    private String remarks;
    private Integer orderNo;
    private String status;

}

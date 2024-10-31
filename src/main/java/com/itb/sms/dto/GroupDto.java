package com.itb.sms.dto;

import lombok.Data;

@Data
public class GroupDto {

    private Long id;
    private String groupName;
    private String status;
    private String deleted="N";



}

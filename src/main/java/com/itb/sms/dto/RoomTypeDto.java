package com.itb.sms.dto;

import lombok.Data;

@Data
public class RoomTypeDto {

    private Long id;
    private String typeName;
    private String status;
    private Long instituteId;
    private Long branchId;
    private String deleted="N";



}

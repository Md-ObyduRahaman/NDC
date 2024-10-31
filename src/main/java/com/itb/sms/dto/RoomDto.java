package com.itb.sms.dto;

import lombok.Data;

@Data
public class RoomDto {

    private Long id;
    private String roomName;
    private Long typeId;
    private String typeName;
    private Long buildingId;
    private String buildingName;
    private Integer noOfSeat;
    private String acStatus;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;
    private String remarks;



}

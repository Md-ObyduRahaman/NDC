package com.itb.sms.dto;

import lombok.Data;

@Data
public class BuildingDto {

    private Long id;
    private String buildingName;
    private Long cityId;
    private String cityName;
    private Long postId;
    private String postName;
    private String picture;
    private Integer noOfRoom;
    private String address;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

package com.itb.sms.dto;

import lombok.Data;

@Data
public class BranchDto {

    private Long id;
    private String branchName;
    private String logo;
    private Long cityId;
    private String cityName;
    private Long postId;
    private String postName;
    private String address1;
    private String address2;
    private String phoneNumber;
    private String email;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

package com.itb.sms.dto;

import lombok.Data;

@Data
public class QuotaDto {

    private Long id;
    private String quotaName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

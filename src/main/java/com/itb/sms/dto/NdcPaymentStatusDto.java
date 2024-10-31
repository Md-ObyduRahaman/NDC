package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcPaymentStatusDto {

    @JsonProperty("PAY_CODE")
    private String PAY_CODE;

    @JsonProperty("PAY_STATUS")
    private String PAY_STATUS;



}

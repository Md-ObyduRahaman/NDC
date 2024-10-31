package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcPaySlipDto {

    @JsonProperty("APP_ROLL_NO")
    private String APP_ROLL_NO;

    @JsonProperty("PAY_ID")
    private String PAY_ID;

    @JsonProperty("RESULT_CODE")
    private String RESULT_CODE;

    @JsonProperty("PAYMENT_ID")
    private String PAYMENT_ID;

    @JsonProperty("TRX_ID")
    private String TRX_ID;

    @JsonProperty("TRX_STATUS")
    private String TRX_STATUS;

    @JsonProperty("AMOUNT")
    private String AMOUNT;

    @JsonProperty("CURRENCY")
    private String CURRENCY;

    @JsonProperty("INTENT")
    private String INTENT;

    @JsonProperty("INV_NO")
    private String INV_NO;

    @JsonProperty("MSISDN")
    private String MSISDN;

    @JsonProperty("PAY_TYPE")
    private String PAY_TYPE;

    @JsonProperty("TRX_DATE")
    private String TRX_DATE;





}

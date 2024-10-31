package com.itb.sms.dto;

import lombok.Data;

@Data
public class BkashCreatePaymentResponseDto {

    private String paymentID;
    private String bkashURL;
    private String callbackURL;
    private String successCallbackURL;
    private String failureCallbackURL;
    private String cancelledCallbackURL;
    private String amount;
    private String currency;
    private String intent;
    private String payerReference;
    private String agreementID;
    private String paymentCreateTime;
    private String transactionStatus;
    private String merchantInvoiceNumber;
}

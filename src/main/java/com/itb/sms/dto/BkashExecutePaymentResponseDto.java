package com.itb.sms.dto;

import lombok.Data;

@Data
public class BkashExecutePaymentResponseDto {

    private String paymentID;
    private String agreementID;
    private String payerReference;
    private String customerMsisdn;
    private String trxID;
    private String amount;
    private String currency;
    private String intent;
    private String transactionStatus;
    private String paymentExecuteTime;
    private String merchantInvoiceNumber;
    private String cmedStatusCode;
    private String cmedStatusMessage;
}

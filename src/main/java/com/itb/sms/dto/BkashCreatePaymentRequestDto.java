package com.itb.sms.dto;

import lombok.Data;

@Data
public class BkashCreatePaymentRequestDto {


    private String amount;


    private String currency;


    private String intent;

    private String  merchantInvoiceNumber;
}

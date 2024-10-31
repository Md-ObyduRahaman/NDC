package com.itb.sms.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.sms.dto.*;
import com.itb.sms.utility.PaymentUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BkashTokenServiceImpl {

    RestTemplate restTemplate = new RestTemplate();

    @Value("${token-url}")
    private String tokenUrl;

    @Value("${create-url}")
    private String createUrl;

    @Value("${execute-url}")
    private String executeUrl;

    @Value("${app_key}")
    private String appKey;

    @Value("${app_secret}")
    private String appSecret;

    @Value("${bkash-user}")
    private String bkashUser;

    @Value("${password}")
    private String password;


    public BkashTokenDto getToken() {
        HttpEntity<String> request = PaymentUtils.getRequest(this.getLoginRequestBody(), PaymentUtils.createHeaders(bkashUser, password, null, null));
        BkashTokenDto response = this.restTemplate.postForObject(tokenUrl, request, BkashTokenDto.class);
        System.out.println("id token: "+response.getIdToken());
        return response;

    }


    private String getLoginRequestBody() {
        return "{\n" +
                "\"app_key\": \"" + appKey + "\",\n" +
                "\"app_secret\": \"" + appSecret + "\"\n" +
                "}";
    }

    public BkashCreatePaymentResponseDto create(BkashCreatePaymentRequestDto body , String token) throws JsonProcessingException {
        String accessToken = getGrantToken(token);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> request = PaymentUtils.getRequest(objectMapper.writeValueAsString(body), PaymentUtils.createHeaders(null, null, accessToken, appKey));
        BkashCreatePaymentResponseDto response = this.restTemplate.postForObject(createUrl, request, BkashCreatePaymentResponseDto.class);
        return response;
    }

    public BkashExecutePaymentResponseDto execute(BkashExecutePaymentRequestDto body , String token) throws JsonProcessingException {
        String accessToken = getGrantToken(token);

        ObjectMapper objectMapper = new ObjectMapper();
        HttpEntity<String> request = PaymentUtils.getRequest(objectMapper.writeValueAsString(body), PaymentUtils.createHeaders(null, null, accessToken, appKey));
        BkashExecutePaymentResponseDto response = this.restTemplate.postForObject(executeUrl, request, BkashExecutePaymentResponseDto.class);
        return response;
    }

    private String getGrantToken(String token) {

        String accessToken = token !=null?token:this.getToken().getIdToken();

        return accessToken;
    }



}

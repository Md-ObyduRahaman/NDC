package com.itb.sms.utility;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class PaymentUtils {

    public static HttpEntity<String> getRequest(String body , HttpHeaders headers)  {
        return new HttpEntity(body, headers);
    }

    public static HttpHeaders createHeaders(String username, String password, String authorization, String xAppKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("username", username);
        headers.add("password", password);
        headers.add("authorization", authorization);
        headers.add("x-app-key", xAppKey);

        return headers;
    }
}

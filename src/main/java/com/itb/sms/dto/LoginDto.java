package com.itb.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {

    private String p_SMS_MOBILE_NO;
    private String p_User_Pass;

}

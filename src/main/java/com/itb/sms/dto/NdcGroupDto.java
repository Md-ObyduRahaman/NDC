package com.itb.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;



@Data
public class NdcGroupDto  {

    @JsonProperty("GR_CODE")
    private String GR_CODE;

    @JsonProperty("GR_NAME")
    private String GR_NAME;


}

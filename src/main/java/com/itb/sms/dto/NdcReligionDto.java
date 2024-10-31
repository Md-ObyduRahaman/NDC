package com.itb.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcReligionDto {

    @JsonProperty("RG_CODE")
    private String RG_CODE;

    @JsonProperty("RG_NAME")
    private String RG_NAME;


}

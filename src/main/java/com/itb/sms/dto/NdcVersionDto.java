package com.itb.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data

public class NdcVersionDto {

    @JsonProperty("VAR_CODE")
    private String VAR_CODE;

    @JsonProperty("VAR_NAME")
    private String VAR_NAME;


}

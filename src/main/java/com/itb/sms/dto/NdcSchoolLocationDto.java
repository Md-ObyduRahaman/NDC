package com.itb.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcSchoolLocationDto {

    @JsonProperty("LOC_CODE")
    private String LOC_CODE;

    @JsonProperty("LOC_NAME")
    private String LOC_NAME;

}

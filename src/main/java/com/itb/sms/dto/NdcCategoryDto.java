package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcCategoryDto {

    @JsonProperty("CAT_CODE")
    private String CAT_CODE;

    @JsonProperty("CAT_NAME")
    private String CAT_NAME;



}

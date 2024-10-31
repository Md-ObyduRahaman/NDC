package com.itb.sms.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcBoardDto {

    @JsonProperty("BOARD_CODE")
    private String BOARD_CODE;

    @JsonProperty("BOARD_NAME")
    private String BOARD_NAME;



}

package com.itb.sms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NdcExamScheduleDto {

    @JsonProperty("SCH_CODE")
    private String SCH_CODE;

    @JsonProperty("SCH_DESC")
    private String SCH_DESC;


}

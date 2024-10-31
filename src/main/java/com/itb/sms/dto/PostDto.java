package com.itb.sms.dto;

import lombok.Data;

@Data
public class PostDto {

    private Long id;
    private String postName;
    private Long cityId;
    private String cityName;
    private String status;
    private String deleted="N";



}

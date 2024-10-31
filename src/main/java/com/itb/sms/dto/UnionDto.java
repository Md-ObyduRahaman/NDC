package com.itb.sms.dto;

import lombok.Data;

@Data
public class UnionDto {

    private Long id;
    private String unionName;
    private Long postId;
    private String postName;
    private String status;
    private String deleted="N";



}

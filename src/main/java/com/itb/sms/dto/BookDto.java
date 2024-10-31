package com.itb.sms.dto;

import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String bookName;
    private String status;
    private String deleted="N";
    private Long instituteId;
    private Long branchId;



}

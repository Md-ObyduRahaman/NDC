package com.itb.sms.mapper;


import com.itb.sms.dto.BookDto;
import com.itb.sms.model.BookInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {


    private final UserService userService;

    public BookMapper(UserService userService) {
        this.userService = userService;
    }


    public BookInfo map(BookDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        BookInfo entity = new BookInfo();
        entity.setId(dto.getId());
        entity.setBookName(dto.getBookName());
        entity.setStatus(dto.getStatus());
        entity.setDeleted(dto.getDeleted());
        entity.setInstituteId(userInfo.getInstituteId());
        entity.setBranchId(userInfo.getBranchId());

        if (dto.getId() == null) {
            entity.setCreatedBy(userInfo.getId());
        } else {
            entity.setUpdatedBy(userInfo.getId());
        }

        return entity;

    }


    public List<BookDto> mapList(List<BookInfo> entities) {
        List<BookDto> list = new ArrayList<>();

        BookDto dto;

        for (BookInfo entity : entities) {

            dto = new BookDto();
            dto.setId(entity.getId());
            dto.setBookName(entity.getBookName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public BookDto map(BookInfo entity) {

        BookDto dto = new BookDto();

        dto.setId(entity.getId());
        dto.setBookName(entity.getBookName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

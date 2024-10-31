package com.itb.sms.service;

import com.itb.sms.dto.BookDto;
import com.itb.sms.model.UserInfo;

import java.util.List;


public interface BookService {

    BookDto getById(Long id);

    List<BookDto> findAll(UserInfo user, String status, String deleted);

    void saveOrUpdate(BookDto dto);

}

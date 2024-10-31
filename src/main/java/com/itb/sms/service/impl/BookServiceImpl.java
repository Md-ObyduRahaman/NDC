package com.itb.sms.service.impl;

import com.itb.sms.dto.BookDto;
import com.itb.sms.mapper.BookMapper;
import com.itb.sms.model.BookInfo;
import com.itb.sms.model.UserInfo;
import com.itb.sms.repository.BookRepository;
import com.itb.sms.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookServiceImpl(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getById(Long id) {
        Optional<BookInfo> entity = bookRepository.findById(id);

        return bookMapper.map(entity.get());

    }


    @Override
    public List<BookDto> findAll(UserInfo user, String status, String deleted) {
        if (status != null) {

            return bookMapper.mapList(bookRepository.findAll().stream()
                    .filter(info ->info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            && info.getStatus().equals(status)
                            && info.getDeleted().equals(deleted))
                    .collect(Collectors.toList()));
        } else {

            return bookMapper.mapList(bookRepository.findAll().stream()
                    .filter(info -> info.getInstituteId().equals(user.getInstituteId())
                            && info.getBranchId().equals(user.getBranchId())
                            &&info.getDeleted().equals(deleted)).collect(Collectors.toList()));
        }

    }

    @Override
    public void saveOrUpdate(BookDto dto) {


            bookRepository.save(bookMapper.map(dto));

    }


}

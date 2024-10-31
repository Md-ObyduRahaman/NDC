package com.itb.sms.mapper;


import com.itb.sms.dto.SubjectBookDto;
import com.itb.sms.model.*;
import com.itb.sms.repository.BookRepository;
import com.itb.sms.repository.SessionRepository;
import com.itb.sms.repository.SubjectRepository;
import com.itb.sms.repository.SubjectTypeRepository;
import com.itb.sms.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SubjectBookMapper {


    private final UserService userService;
    private final SubjectTypeRepository subjectTypeRepository;
    private final SubjectRepository subjectRepository;
    private final BookRepository bookRepository;
    private final SessionRepository sessionRepository;

    public SubjectBookMapper(UserService userService,SubjectTypeRepository subjectTypeRepository,
                             SubjectRepository subjectRepository,BookRepository bookRepository,
                             SessionRepository sessionRepository) {
        this.userService = userService;
        this.subjectTypeRepository = subjectTypeRepository;
        this.subjectRepository = subjectRepository ;
        this.bookRepository = bookRepository ;
        this.sessionRepository = sessionRepository ;
    }


    public SubjectBookInfo map(SubjectBookDto dto) {

        UserInfo userInfo = userService.getCurrentUser();

        SubjectBookInfo entity = new SubjectBookInfo();
        entity.setId(dto.getId());
        entity.setSubBookName(dto.getSubBookName());

        Optional<SubjectTypeInfo> subjectTypeInfo=subjectTypeRepository.findById(dto.getSubjectTypeId());
        if(subjectTypeInfo.isPresent()){
            entity.setSubjectTypeInfo(subjectTypeInfo.get());
        }else {

            new Exception("Subject Type is not exist with id " + dto.getSubjectTypeId());
        }

        Optional<SubjectInfo> subjectInfo=subjectRepository.findById(dto.getSubjectId());
        if(subjectInfo.isPresent()){
            entity.setSubjectInfo(subjectInfo.get());
        }else {

            new Exception("Subject is not exist with id " + dto.getSubjectId());
        }

        Optional<BookInfo> bookInfo=bookRepository.findById(dto.getBookId());
        if(bookInfo.isPresent()){
            entity.setBookInfo(bookInfo.get());
        }else {

            new Exception("Book is not exist with id " + dto.getBookId());
        }

        Optional<SessionInfo> sessionInfo=sessionRepository.findById(dto.getSessionId());
        if(sessionInfo.isPresent()){
            entity.setSessionInfo(sessionInfo.get());
        }else {

            new Exception("Session is not exist with id " + dto.getSessionId());
        }

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


    public List<SubjectBookDto> mapList(List<SubjectBookInfo> entities) {
        List<SubjectBookDto> list = new ArrayList<>();

        SubjectBookDto dto;

        for (SubjectBookInfo entity : entities) {

            dto = new SubjectBookDto();
            dto.setId(entity.getId());
            dto.setSubBookName(entity.getSubBookName());
            dto.setSubjectTypeId(entity.getSubjectTypeInfo().getId());
            dto.setSubjectTypeName(entity.getSubjectTypeInfo().getTypeName());
            dto.setSubjectId(entity.getSubjectInfo().getId());
            dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
            dto.setBookId(entity.getBookInfo().getId());
            dto.setBookName(entity.getBookInfo().getBookName());
            dto.setSessionId(entity.getSessionInfo().getId());
            dto.setSessionName(entity.getSessionInfo().getSessionName());
            dto.setStatus(entity.getStatus());
            dto.setDeleted(entity.getDeleted());
            dto.setInstituteId(entity.getInstituteId());
            dto.setBranchId(entity.getBranchId());

            list.add(dto);
        }

        return list;


    }


    public SubjectBookDto map(SubjectBookInfo entity) {

        SubjectBookDto dto = new SubjectBookDto();

        dto.setId(entity.getId());
        dto.setSubBookName(entity.getSubBookName());
        dto.setSubjectTypeId(entity.getSubjectTypeInfo().getId());
        dto.setSubjectTypeName(entity.getSubjectTypeInfo().getTypeName());
        dto.setSubjectId(entity.getSubjectInfo().getId());
        dto.setSubjectName(entity.getSubjectInfo().getSubjectName());
        dto.setBookId(entity.getBookInfo().getId());
        dto.setBookName(entity.getBookInfo().getBookName());
        dto.setSessionId(entity.getSessionInfo().getId());
        dto.setSessionName(entity.getSessionInfo().getSessionName());
        dto.setStatus(entity.getStatus());
        dto.setDeleted(entity.getDeleted());
        dto.setInstituteId(entity.getInstituteId());
        dto.setBranchId(entity.getBranchId());


        return dto;


    }
}

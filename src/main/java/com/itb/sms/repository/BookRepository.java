package com.itb.sms.repository;


import com.itb.sms.model.BookInfo;
import com.itb.sms.model.FacultyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookInfo, Long> {



}
package com.itb.sms.repository;


import com.itb.sms.model.TeacherSubjectInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherSubjectRepository extends JpaRepository<TeacherSubjectInfo, Long> {



}
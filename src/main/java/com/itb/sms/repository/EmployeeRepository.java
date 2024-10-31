package com.itb.sms.repository;


import com.itb.sms.model.EmployeeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<EmployeeInfo, Long> {

    @Query(value = "SELECT LPAD(NVL(SUBSTR(emp_code, -6), 0) + 1, 6, 0) FROM ed_employee where institute_id= :instituteId and branch_id= :branchId", nativeQuery = true)
    String getUdEmployeeCode(@Param("instituteId") Long instituteId, @Param("branchId") Long branchId);


}
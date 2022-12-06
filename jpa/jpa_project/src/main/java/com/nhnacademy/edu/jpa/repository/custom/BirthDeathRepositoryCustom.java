package com.nhnacademy.edu.jpa.repository.custom;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface BirthDeathRepositoryCustom {

    //NOTE: querydsl은 insert를 지원하지 않는다.

    @Transactional
    long updateByPk(Integer residentSerialNumber, String birthDeathTypeCode, String emailAddress, String phoneNumber);

    @Transactional
    boolean deleteBirthDeathReportResidentPk(Integer residentSerialNumber, String birthDeathTypeCode);
}

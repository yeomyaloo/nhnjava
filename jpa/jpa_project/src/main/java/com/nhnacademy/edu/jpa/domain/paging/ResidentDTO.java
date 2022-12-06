package com.nhnacademy.edu.jpa.domain.paging;


import org.springframework.beans.factory.annotation.Value;

public interface ResidentDTO {

    @Value("#{target.residentSerialNumber}")
    Integer getResidentSerialNumber();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.genderCode}")
    String getGenderCode();

    @Value("#{target.registrationBaseAddress}")
    String getRegistrationBaseAddress();
}

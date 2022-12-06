package com.nhnacademy.edu.jpa.domain.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Getter
public class ResidentRequestDTO {

    @NotNull
    private Integer residentSerialNumber;


    @NotNull
    private String name;

    @NotNull
    private String residentRegistrationNumber;

    @NotNull
    private String genderCode;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp birthDate;

    @NotNull
    private String birthPlaceCode;

    @NotNull
    private String registrationBaseAddress;
}

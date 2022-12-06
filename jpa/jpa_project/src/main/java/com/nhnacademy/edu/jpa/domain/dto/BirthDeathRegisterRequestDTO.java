package com.nhnacademy.edu.jpa.domain.dto;

import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;
import java.sql.Date;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BirthDeathRegisterRequestDTO {

    @NotNull
    private Integer residentSerialNumber;

    @NotNull
    private String birthDeathTypeCode;

    @NotNull
    private Integer reportResidentSerialNumber;


    @NotNull
    private Date birthDeathReportDate;

    @NotNull
    private String phoneNumber;

    @Nullable
    private String deathReportQualificationsCode;

    @Nullable
    private String birthReportQualificationsCode;

    @Nullable
    private String emailAddress;


    public static BirthDeathRegisterRequestDTO of(BirthDeathReportResident birthDeathReportResident){
        return new BirthDeathRegisterRequestDTO(
                birthDeathReportResident.getPk().getResidentSerialNumber(),
                birthDeathReportResident.getPk().getBirthDeathTypeCode(),
                birthDeathReportResident.getReportResidentSerialNumber(),
                birthDeathReportResident.getBirthDeathReportDate(),
                birthDeathReportResident.getPhoneNumber(),
                birthDeathReportResident.getDeathReportQualificationsCode(),
                birthDeathReportResident.getBirthReportQualificationsCode(),
                birthDeathReportResident.getEmailAddress());
    }
}

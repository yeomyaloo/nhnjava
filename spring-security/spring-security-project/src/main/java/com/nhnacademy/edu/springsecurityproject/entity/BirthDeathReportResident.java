package com.nhnacademy.edu.springsecurityproject.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Table(name="birth_death_report_resident")
@Entity
@Getter
@NoArgsConstructor
public class BirthDeathReportResident {

    @EmbeddedId
    private Pk pk;


    @MapsId("residentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "resident_serial_number", insertable = false, updatable = false)
    private Resident resident;

    @Column(name = "report_resident_serial_number")
    private Integer reportResidentSerialNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_death_report_date")
    private Date birthDeathReportDate;

    @Column(name = "birth_report_qualifications_code")
    private String birthReportQualificationsCode;

    @Column(name = "death_report_qualifications_code")
    private String deathReportQualificationsCode;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "phone_number")
    private String phoneNumber;



    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Getter
    public static class Pk implements Serializable {
        @Column(name = "birth_death_type_code")
        private String birthDeathTypeCode;

        @Column(name = "resident_serial_number")
        private Integer residentSerialNumber;

    }

    public BirthDeathReportResident(Pk pk,
                                    Resident resident,
                                    Integer reportResidentSerialNumber,
                                    Date birthDeathReportDate,
                                    String birthReportQualificationsCode,
                                    String deathReportQualificationsCode,
                                    String emailAddress,
                                    String phoneNumber) {
        this.pk = pk;
        this.resident=resident;
        this.reportResidentSerialNumber = reportResidentSerialNumber;
        this.birthDeathReportDate = birthDeathReportDate;
        this.birthReportQualificationsCode = birthReportQualificationsCode;
        this.deathReportQualificationsCode = deathReportQualificationsCode;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }


}

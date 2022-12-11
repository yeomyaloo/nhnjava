package com.nhnacademy.edu.springsecurityproject.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Table(name = "household_movement_address")
@Getter
@NoArgsConstructor
public class HouseholdMovementAddress {

    @EmbeddedId
    private Pk pk;


    @Column(name = "house_movement_address")
    private String houseMovementAddress;


    @Column(name = "last_address_yn")
    private char lastAddressYN;


    @MapsId("householdSerialNumber")
    @JoinColumn(name = "household_serial_number")
    @ManyToOne
    private Household household;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {

        @Column(name = "household_serial_number")
        private Integer householdSerialNumber;

        @Column(name = "house_movement_report_date")
        private Date houseMovementReportDate;

    }
}

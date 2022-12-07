package com.nhnacademy.edu.springsecurityproject.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "household")
@Getter
@RequiredArgsConstructor
public class Household {

    @Id
    @Column(name = "household_serial_number")
    private Integer householdSerialNumber;

    @JoinColumn(name="household_resident_serial_number")
    @ManyToOne
    private Resident resident;

    @Column(name = "household_composition_date")
    private Date householdCompositionDate;

    @Column(name = "household_composition_reason_code")
    private String householdCompositionReasonCode;

    @Column(name = "current_house_movement_address")
    private String currentHouseMovementAddress;


}

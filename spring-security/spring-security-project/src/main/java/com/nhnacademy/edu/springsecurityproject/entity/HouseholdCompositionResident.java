package com.nhnacademy.edu.springsecurityproject.entity;


import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Table(name = "household_composition_resident")
@Entity
@Getter
@RequiredArgsConstructor
public class HouseholdCompositionResident implements Serializable{

    @EmbeddedId
    private Pk pk;


    @Column(name = "report_date")
    private Date reportDate;


    @Column(name = "household_relationship_code")
    private String householdRelationshipCode;

    @Column(name = "household_composition_change_reason_code")
    private String householdCompositionChangeReasonCode;

    @MapsId("householdSerialNumber")
    @JoinColumn(name = "household_serial_number")
    @ManyToOne
    private Household household;

    @MapsId("residentSerialNumber")
    @JoinColumn(name = "resident_serial_number")
    @ManyToOne
    private Resident resident;

    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {

        @Column(name = "resident_serial_number")
        private Integer residentSerialNumber;


        //세대주
        @Column(name = "household_serial_number")
        private Integer householdSerialNumber;



    }
}

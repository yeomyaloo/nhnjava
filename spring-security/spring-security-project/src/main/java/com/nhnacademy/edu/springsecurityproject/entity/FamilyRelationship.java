package com.nhnacademy.edu.springsecurityproject.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "family_relationship")
@Getter
@NoArgsConstructor
public class FamilyRelationship {

    @EmbeddedId
    private Pk pk;


    @MapsId("baseResidentSerialNumber")
    @ManyToOne
    @JoinColumn(name = "base_resident_serial_number",insertable = false, updatable = false)
    private Resident resident;

    @Column(name = "family_relationship_code")
    private String familyRelationshipCode;

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class Pk implements Serializable {

        @Column(name = "base_resident_serial_number")
        private Integer baseResidentSerialNumber;

        @Column(name = "family_resident_serial_number")
        private Integer familyResidentSerialNumber;

    }
    public FamilyRelationship(Pk pk, Resident resident, String familyRelationshipCode) {
        this.pk = pk;
        this.resident = resident;
        this.familyRelationshipCode = familyRelationshipCode;

    }
}

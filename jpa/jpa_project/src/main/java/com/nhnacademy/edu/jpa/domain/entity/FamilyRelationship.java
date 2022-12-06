package com.nhnacademy.edu.jpa.domain.entity;


import lombok.*;

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
    public FamilyRelationship(Pk pk, String familyRelationshipCode, Resident resident) {
        this.pk = pk;
        this.familyRelationshipCode = familyRelationshipCode;
    }
}

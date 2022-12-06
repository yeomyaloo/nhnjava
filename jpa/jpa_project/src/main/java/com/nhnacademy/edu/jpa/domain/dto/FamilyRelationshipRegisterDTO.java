package com.nhnacademy.edu.jpa.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
public class FamilyRelationshipRegisterDTO {

    @NotNull
    Integer familyResidentSerialNumber;
    @NotNull
    String familyRelationshipCode;

}

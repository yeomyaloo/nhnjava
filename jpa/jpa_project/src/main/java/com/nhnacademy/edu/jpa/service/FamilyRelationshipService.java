package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.FamilyRelationshipRegisterDTO;
import com.nhnacademy.edu.jpa.domain.entity.FamilyRelationship;

import java.util.List;

public interface FamilyRelationshipService {

    List<FamilyRelationship> getRelationships();

    FamilyRelationship registerFamilyRelationship(Integer residentNum, FamilyRelationshipRegisterDTO dto);

    void modifyFamilyRelationship(Integer residentNum, Integer familyResidentSerialNum, String familyRelationshipCode);

    boolean deleteFamilyRelationship(Integer resident, Integer familyResident);



}

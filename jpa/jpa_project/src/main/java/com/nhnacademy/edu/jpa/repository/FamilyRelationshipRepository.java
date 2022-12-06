package com.nhnacademy.edu.jpa.repository;

import com.nhnacademy.edu.jpa.domain.entity.FamilyRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FamilyRelationshipRepository extends JpaRepository<FamilyRelationship, FamilyRelationship.Pk> {


    List<FamilyRelationship> getAllBy();

    FamilyRelationship.Pk findByPkBaseResidentSerialNumberAndPkBaseResidentSerialNumber(Integer resident, Integer familyResident);


    FamilyRelationship getFamilyRelationshipByPk_BaseResidentSerialNumberAndPk_FamilyResidentSerialNumber(Integer resident, Integer familyResident);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE FamilyRelationship fr set fr.familyRelationshipCode = ?3 where fr.pk.baseResidentSerialNumber = ?1 and fr.pk.familyResidentSerialNumber = ?2")
    @Transactional
    void updateFamilyRelationship(@Param("baseResidentSerialNumber") Integer baseResidentSerialNumber,
                                                @Param("familyResidentSerialNumber") Integer familyResidentSerialNumber,
                                                @Param("familyRelationshipCode") String familyRelationshipCode);



    @Modifying(clearAutomatically = true)
    @Query("delete from FamilyRelationship fr where fr.pk.baseResidentSerialNumber = ?1 and fr.pk.familyResidentSerialNumber = ?2")
    void deleteFamilyRelationshipByPk(@Param("baseResidentSerialNumber") Integer baseResidentSerialNumber,
                                      @Param("familyResidentSerialNumber") Integer familyResidentSerialNumber);

}

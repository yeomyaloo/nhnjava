package com.nhnacademy.edu.springsecurityproject.repositoty;

import com.nhnacademy.edu.springsecurityproject.domain.FamilyRelationshipReportInterface;
import com.nhnacademy.edu.springsecurityproject.entity.HouseholdCompositionResident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseholdCompositionResidentRepository extends JpaRepository<HouseholdCompositionResident, HouseholdCompositionResident.Pk> {


    @Query("select hc.pk.householdSerialNumber from HouseholdCompositionResident as hc where hc.pk.residentSerialNumber=?1")
    Integer findHouseholdSerialNumber(Integer residentSerialNumber);


    @Query(value = "select r.name, r.residentRegistrationNumber, r.genderCode, r.registrationBaseAddress, hc.householdCompositionChangeReasonCode " +
            "from Resident as r inner join HouseholdCompositionResident as hc on r.residentSerialNumber = hc.pk.residentSerialNumber " +
            "where hc.pk.householdSerialNumber = ?1")
    List<FamilyRelationshipReportInterface> getHouseList(Integer householdSerialNumber);



}

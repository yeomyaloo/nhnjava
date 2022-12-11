package com.nhnacademy.edu.springsecurityproject.service;

import com.nhnacademy.edu.springsecurityproject.domain.FamilyRelationshipReportInterface;
import com.nhnacademy.edu.springsecurityproject.entity.Resident;
import com.nhnacademy.edu.springsecurityproject.repositoty.HouseholdCompositionResidentRepository;
import com.nhnacademy.edu.springsecurityproject.repositoty.ResidentRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService{

    private final HouseholdCompositionResidentRepository householdCompositionResidentRepository;

    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(HouseholdCompositionResidentRepository householdCompositionResidentRepository, ResidentRepository residentRepository) {
        this.householdCompositionResidentRepository = householdCompositionResidentRepository;
        this.residentRepository = residentRepository;
    }


    @Override
    @Transactional
    public List<FamilyRelationshipReportInterface> getAllFamilyList() {


        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        Resident byUserId = residentRepository.findByUserId(userDetails.getUsername());
        Integer residentSerialNumber = byUserId.getResidentSerialNumber();

        Integer householdSerialNumber = householdCompositionResidentRepository.findHouseholdSerialNumber(residentSerialNumber);

        List<FamilyRelationshipReportInterface> familyList = householdCompositionResidentRepository.getHouseList(householdSerialNumber);


        return familyList;
    }
}

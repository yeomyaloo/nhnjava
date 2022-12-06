package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.FamilyRelationshipRegisterDTO;
import com.nhnacademy.edu.jpa.domain.entity.FamilyRelationship;
import com.nhnacademy.edu.jpa.domain.entity.Resident;
import com.nhnacademy.edu.jpa.exception.FamilyRelationshipNotFoundException;
import com.nhnacademy.edu.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.edu.jpa.repository.ResidentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class FamilyRelationshipServiceImpl implements FamilyRelationshipService{

    private final FamilyRelationshipRepository familyRelationshipRepository;
    private final ResidentRepository residentRepository;

    public FamilyRelationshipServiceImpl(FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }


    @Override
    public List<FamilyRelationship> getRelationships() {
        List<FamilyRelationship> familyRelationships = familyRelationshipRepository.getAllBy();

        if(familyRelationships.isEmpty()){
            throw new FamilyRelationshipNotFoundException();
        }

        return familyRelationships;
    }

    //save() = JpaRepository 기본 구현 메소드 ..
    @Override
    @Transactional
    public FamilyRelationship registerFamilyRelationship(Integer residentNum, FamilyRelationshipRegisterDTO dto) {

        String storeRelationshipCode = getString(dto.getFamilyRelationshipCode());
        Optional<Resident> resident = residentRepository.findById(residentNum);

        FamilyRelationship familyRelationship
                = new FamilyRelationship(
                        new FamilyRelationship.Pk(residentNum, dto.getFamilyResidentSerialNumber()), storeRelationshipCode, resident.get());

        return familyRelationshipRepository.save(familyRelationship);
    }


    //FIXME: 해당 부분을 queryDsl로 처리하는 방법을 강구해보자
    @Override
    @Transactional(readOnly = true)
    public void modifyFamilyRelationship(Integer residentNum, Integer familyResidentSerialNum ,String familyRelationshipCode) {

        String storeRelationshipCode = getString(familyRelationshipCode);

        familyRelationshipRepository.updateFamilyRelationship(residentNum, familyResidentSerialNum, storeRelationshipCode);

    }



    @Override
    @Transactional
    public boolean deleteFamilyRelationship(Integer resident, Integer familyResident) {
        FamilyRelationship.Pk pk = familyRelationshipRepository.getFamilyRelationshipByPk_BaseResidentSerialNumberAndPk_FamilyResidentSerialNumber(resident, familyResident).getPk();
        if(Objects.nonNull(pk)){
            familyRelationshipRepository.deleteFamilyRelationshipByPk(resident, familyResident);
            return true;
        }
        return false;
    }

    //FIXME : enum 타입으로 리팩토링을 고민해볼 것...
    private static String getString(String familyRelationshipCode) {
        String storeRelationshipCode = "";
        if(familyRelationshipCode.equals("father")){
            storeRelationshipCode= "부";
        } else if (familyRelationshipCode.equals("mother")) {
            storeRelationshipCode = "모";
        }else if (familyRelationshipCode.equals("spouse")) {
            storeRelationshipCode = "배우자";
        }else{
            storeRelationshipCode = "자녀";
        }
        return storeRelationshipCode;
    }
}

package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.BirthDeathModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.BirthDeathRegisterRequestDTO;
import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;

public interface BirthDeathService {

    BirthDeathReportResident registerBirthDeath(BirthDeathRegisterRequestDTO dto, Integer serialNumber);

    void modifyBirthDeath(Integer num, String code, BirthDeathModifyRequestDTO dto);
    boolean deleteBirthDeath(Integer num, String code);


}

package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.BirthDeathModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.BirthDeathRegisterRequestDTO;
import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import com.nhnacademy.edu.jpa.repository.BirthDeathReportResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BirthDeathServiceImpl implements BirthDeathService {

    private final BirthDeathReportResidentRepository birthDeathReportResidentRepository;

    public BirthDeathServiceImpl(BirthDeathReportResidentRepository birthDeathReportResidentRepository) {
        this.birthDeathReportResidentRepository = birthDeathReportResidentRepository;
    }

    @Override
    @Transactional
    public BirthDeathReportResident registerBirthDeath(BirthDeathRegisterRequestDTO dto, Integer serialNumber) {

        return birthDeathReportResidentRepository.save(new BirthDeathReportResident(
                new BirthDeathReportResident.Pk(dto.getBirthDeathTypeCode(),serialNumber),
                dto.getReportResidentSerialNumber(),
                dto.getBirthDeathReportDate(),
                dto.getBirthReportQualificationsCode(),
                dto.getDeathReportQualificationsCode(),
                dto.getEmailAddress(),
                dto.getPhoneNumber()));
    }

    @Override
    public void modifyBirthDeath(Integer num, String code, BirthDeathModifyRequestDTO dto) {
        birthDeathReportResidentRepository.updateByPk(num, code, dto.getEmail(), dto.getPhoneNumber());
    }

    @Override
    public boolean deleteBirthDeath(Integer num, String code) {
        if( birthDeathReportResidentRepository.deleteBirthDeathReportResidentPk(num, code);{
            return true;
        }
        return false;
    }

}

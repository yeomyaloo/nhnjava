package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.ResidentModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.ResidentRequestDTO;
import com.nhnacademy.edu.jpa.domain.paging.ResidentDTO;
import com.nhnacademy.edu.jpa.domain.entity.Resident;
import com.nhnacademy.edu.jpa.exception.ResidentDoesNotExistException;
import com.nhnacademy.edu.jpa.repository.ResidentRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ResidentServiceImpl implements ResidentService{

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    @Override
    @Transactional
    public Resident residentRegister(ResidentRequestDTO dto) {
        Resident resident =
                new Resident(dto.getResidentSerialNumber(),
                        dto.getName(),
                        dto.getResidentRegistrationNumber(),
                        dto.getGenderCode(),
                        dto.getBirthDate(),
                        dto.getBirthPlaceCode(),
                        dto.getRegistrationBaseAddress());
        return residentRepository.save(resident);
    }

    @Override
    public Resident residentModify(ResidentModifyRequestDTO dto, Integer residentId) {

        return residentRepository.save(
                new Resident(
                        residentId,
                        dto.getName(),
                        dto.getResidentRegistrationNumber(),
                        dto.getGenderCode(),
                        dto.getBirthDate(),
                        dto.getBirthPlaceCode(),
                        dto.getRegistrationBaseAddress()));
    }

    @Override
    public List<Resident> getResidents() {

        if(residentRepository.findAll().isEmpty()) {
            throw new ResidentDoesNotExistException();
        }
        return residentRepository.findAll();
    }

    @Override
    public List<ResidentDTO> getResidentWithPageable(Pageable pageable) {
        return residentRepository.getAllBy(pageable).getContent();
    }
}

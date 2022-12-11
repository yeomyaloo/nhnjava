package com.nhnacademy.edu.springsecurityproject.service;


import com.nhnacademy.edu.springsecurityproject.entity.Resident;
import com.nhnacademy.edu.springsecurityproject.repositoty.ResidentRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ResidentServiceImpl implements ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentServiceImpl(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }


    @Override
    @Transactional
    public boolean isResidentEmail(String email) {
        Resident residentEmail = residentRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));

        return true;

    }

    @Override
    @Transactional
    public Resident getResidentBySerialNumber(long serialNumber) {
        return residentRepository.findById((int) serialNumber).orElseThrow(() -> new UsernameNotFoundException(String.valueOf(serialNumber)));
    }

    @Override
    @Transactional
    public Optional<Resident> getResidentByEmail(String email) {

        return residentRepository.findByEmail(email);
    }
}

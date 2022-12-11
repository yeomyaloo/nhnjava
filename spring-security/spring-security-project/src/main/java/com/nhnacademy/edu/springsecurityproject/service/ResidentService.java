package com.nhnacademy.edu.springsecurityproject.service;

import com.nhnacademy.edu.springsecurityproject.entity.Resident;

import java.util.Optional;

public interface ResidentService {

    boolean isResidentEmail(String email);

    Optional<Resident> getResidentByEmail(String email);

    Resident getResidentBySerialNumber(long serialNumber);
}

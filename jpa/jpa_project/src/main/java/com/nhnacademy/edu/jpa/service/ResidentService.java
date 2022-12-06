package com.nhnacademy.edu.jpa.service;

import com.nhnacademy.edu.jpa.domain.dto.ResidentModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.ResidentRequestDTO;
import com.nhnacademy.edu.jpa.domain.paging.ResidentDTO;
import com.nhnacademy.edu.jpa.domain.entity.Resident;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResidentService {

    Resident residentRegister(ResidentRequestDTO dto);

    Resident residentModify(ResidentModifyRequestDTO dto, Integer residentId);


    List<Resident> getResidents();

    List<ResidentDTO> getResidentWithPageable(Pageable pageable);

}

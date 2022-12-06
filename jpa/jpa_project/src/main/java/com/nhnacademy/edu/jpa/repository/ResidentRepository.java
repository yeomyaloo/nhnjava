package com.nhnacademy.edu.jpa.repository;

import com.nhnacademy.edu.jpa.domain.paging.ResidentDTO;
import com.nhnacademy.edu.jpa.domain.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {

    Resident findByResidentSerialNumber(Integer residentId);


    Page<ResidentDTO> getAllBy(Pageable pageable);

}

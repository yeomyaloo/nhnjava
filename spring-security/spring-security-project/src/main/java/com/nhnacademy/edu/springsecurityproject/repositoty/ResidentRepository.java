package com.nhnacademy.edu.springsecurityproject.repositoty;

import com.nhnacademy.edu.springsecurityproject.entity.Resident;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
    Resident findByUserId(String userId);

}

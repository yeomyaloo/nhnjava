package com.nhnacademy.edu.jpa.repository;

import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import com.nhnacademy.edu.jpa.repository.custom.BirthDeathRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BirthDeathReportResidentRepository extends JpaRepository<BirthDeathReportResident,BirthDeathReportResident.Pk> , BirthDeathRepositoryCustom {
}

package com.nhnacademy.edu.springsecurityproject.service;

import com.nhnacademy.edu.springsecurityproject.domain.FamilyRelationshipReportInterface;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FamilyRelationshipService {

    @Transactional
    List<FamilyRelationshipReportInterface> getAllFamilyList();
}

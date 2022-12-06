package com.nhnacademy.edu.jpa.repository;

import com.nhnacademy.edu.jpa.config.RootConfig;
import com.nhnacademy.edu.jpa.config.WebConfig;
import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class BirthDeathReportResidentRepositoryTest {


    @Autowired
    private BirthDeathReportResidentRepository birthDeathReportResidentRepository;



    @Test
    void select(){
        birthDeathReportResidentRepository.findById(new BirthDeathReportResident.Pk("사망",1));
    }

}
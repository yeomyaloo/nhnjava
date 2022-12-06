package com.nhnacademy.edu.jpa.repository;

import com.nhnacademy.edu.jpa.config.RootConfig;
import com.nhnacademy.edu.jpa.config.WebConfig;
import com.nhnacademy.edu.jpa.domain.entity.Resident;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class ResidentRepositoryTest {


    @Autowired
    private ResidentRepository residentRepository;


    @Test
    void matches(){
        Optional<Resident> resident = residentRepository.findById(1);

        if(Objects.nonNull(resident)){
            assertEquals(resident.get().getName(), "남길동");
        }
    }

}
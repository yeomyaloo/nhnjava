package com.nhnacademy.edu.restapi_final_project.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "department_code")
    private String depCode;


    @Column(name = "department_name",nullable = false)
    private String depName;

}

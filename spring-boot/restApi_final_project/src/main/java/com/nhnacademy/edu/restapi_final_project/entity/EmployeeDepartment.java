package com.nhnacademy.edu.restapi_final_project.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_department")
public class EmployeeDepartment {

    @EmbeddedId
    private EDPk edpk;


    @JoinColumn(name = "department_code")
    @MapsId("depCode")
    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;


    @JoinColumn(name ="employee_id")
    @MapsId("empId")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;


    @Embeddable
    @NoArgsConstructor
    @EqualsAndHashCode
    @AllArgsConstructor
    @Getter
    public static class EDPk implements Serializable {

        @Column(name="department_code")
        private String depCode;

        @Column(name="employee_id")
        private Long empId;
    }


}

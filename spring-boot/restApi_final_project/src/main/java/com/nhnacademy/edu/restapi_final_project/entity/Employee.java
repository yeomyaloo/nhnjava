package com.nhnacademy.edu.restapi_final_project.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Getter
public class Employee {


    @Id
    @Column(name = "employee_id")
    private Long empId;


    @Column(name = "employee_name", nullable = false)
    private String empName;




}

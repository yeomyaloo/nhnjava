package com.nhnacademy.edu.restapi_final_project.repository;

import com.nhnacademy.edu.restapi_final_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}

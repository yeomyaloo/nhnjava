package com.nhnacademy.edu.restapi_final_project.domain;

import com.nhnacademy.edu.restapi_final_project.entity.Department;
import com.nhnacademy.edu.restapi_final_project.entity.Employee;
import com.nhnacademy.edu.restapi_final_project.entity.EmployeeDepartment;
import com.nhnacademy.edu.restapi_final_project.repository.EmployeeDepartmentRepository;

public interface DepartmentEmployeeDto {
    Department getDepartment();
    Employee getEmployee();
}

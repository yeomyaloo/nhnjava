package com.nhnacademy.edu.restapi_final_project.service;

import com.nhnacademy.edu.restapi_final_project.domain.DepartmentEmployeeDto;
import com.nhnacademy.edu.restapi_final_project.entity.Department;


import java.util.List;

public interface EmployeeDepartmentService {


    List<DepartmentEmployeeDto> getDepartmentMembers(String code);

}

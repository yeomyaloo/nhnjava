package com.nhnacademy.edu.restapi_final_project.service;

import com.nhnacademy.edu.restapi_final_project.domain.DepartmentEmployeeDto;

import com.nhnacademy.edu.restapi_final_project.entity.Department;
import com.nhnacademy.edu.restapi_final_project.repository.EmployeeDepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService {


    private final EmployeeDepartmentRepository employeeDepartmentRepository;

    public EmployeeDepartmentServiceImpl(EmployeeDepartmentRepository employeeDepartmentRepository) {
        this.employeeDepartmentRepository = employeeDepartmentRepository;
    }

    @Override
    public List<DepartmentEmployeeDto> getDepartmentMembers(String code) {

        List<DepartmentEmployeeDto> employeeRequest = employeeDepartmentRepository.getEmployeeRequest(code);
        return employeeRequest;
    }


}

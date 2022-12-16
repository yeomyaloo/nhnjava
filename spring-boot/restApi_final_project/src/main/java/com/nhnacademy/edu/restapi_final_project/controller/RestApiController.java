package com.nhnacademy.edu.restapi_final_project.controller;


import com.nhnacademy.edu.restapi_final_project.domain.DepartmentEmployeeDto;
import com.nhnacademy.edu.restapi_final_project.service.EmployeeDepartmentService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final EmployeeDepartmentService employeeDepartmentService;


    @GetMapping("department-members/{deptCode}")
    public List<DepartmentEmployeeDto> getDepartmentMemberList(@PathVariable("deptCode") String code){
        List<DepartmentEmployeeDto> departmentMembers = employeeDepartmentService.getDepartmentMembers(code);

        return departmentMembers;
    }



}

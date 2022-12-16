package com.nhnacademy.edu.restapi_final_project.repository;

import com.nhnacademy.edu.restapi_final_project.domain.DepartmentEmployeeDto;

import com.nhnacademy.edu.restapi_final_project.entity.Department;
import com.nhnacademy.edu.restapi_final_project.entity.EmployeeDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, EmployeeDepartment.EDPk> {

    @Query("select e.empName, ed.edpk.empId, d.depName, ed.edpk.depCode from EmployeeDepartment as ed inner join Department as d on ed.edpk.depCode = d.depCode inner join Employee as e on e.empId = ed.edpk.empId where ed.edpk.depCode =?1 ORDER BY ed.edpk.empId ASC")
    List<DepartmentEmployeeDto> getEmployeeRequest(String depCode);

}

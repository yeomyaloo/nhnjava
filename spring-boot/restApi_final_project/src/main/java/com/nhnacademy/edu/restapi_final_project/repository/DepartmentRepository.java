package com.nhnacademy.edu.restapi_final_project.repository;

import com.nhnacademy.edu.restapi_final_project.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, String>{



}

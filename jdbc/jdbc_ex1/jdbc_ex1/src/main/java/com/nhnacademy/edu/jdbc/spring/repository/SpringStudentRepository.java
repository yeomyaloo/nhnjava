package com.nhnacademy.edu.jdbc.spring.repository;

import com.nhnacademy.edu.jdbc.domain.Student;

import java.util.List;

public interface SpringStudentRepository {

    Student findById(long id);

    List<Student> findAll();

    int insert(Student student);

    int deleteById(long id);
}

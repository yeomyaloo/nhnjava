package com.nhnacademy.edu.jdbc1.domain;

import java.sql.Connection;
import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    Student findById(Long id);

    void insert(Student student);

    void updateNameById(Long id, String name);

    void deleteById(Long id);
}

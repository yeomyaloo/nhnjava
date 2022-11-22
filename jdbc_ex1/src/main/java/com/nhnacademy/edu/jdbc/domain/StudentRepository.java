package com.nhnacademy.edu.jdbc.domain;

import com.nhnacademy.edu.jdbc.domain.Student;

import java.sql.Connection;
import java.util.List;

public interface StudentRepository {

    List<Student> findAll(Connection connection);

    Student findById(Connection connection, Long id);

    void insert(Connection connection,Student student);

    void update(Connection connection);

    void delete(Connection connection);
}

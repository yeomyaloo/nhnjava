package com.nhnacademy.edu.jdbc.mybatis.domain;

import java.sql.Connection;
import java.util.List;

public interface StudentRepository {
    List<Student> findAll(Connection connection);

    Student findById(Connection connection, Long id);

    void insert(Connection connection, Student student);

    void updateNameById(Connection connection, Long id, String name);

    void deleteById(Connection connection, Long id);
}

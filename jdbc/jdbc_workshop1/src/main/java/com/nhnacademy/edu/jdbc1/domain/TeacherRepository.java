package com.nhnacademy.edu.jdbc1.domain;

import java.sql.Connection;

public interface TeacherRepository {
    void insert(Connection connection, Student student);

    Page<Teacher> findAll(int page, int size);

}

package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;
import java.util.List;

public interface TeacherRepository {
    void insert(Connection connection, Student student);

    Page<Teacher> findAll(Connection connection,  int page, int size);

}

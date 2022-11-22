package com.nhnacademy.edu.jdbc.mybatis.domain;

import java.sql.Connection;

public interface TeacherRepository {
    void insert(Connection connection, Student student);

    Page<Teacher> findAll(Connection connection,  int page, int size);

}

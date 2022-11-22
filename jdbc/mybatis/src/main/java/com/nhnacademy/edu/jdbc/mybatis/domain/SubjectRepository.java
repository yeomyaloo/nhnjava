package com.nhnacademy.edu.jdbc.mybatis.domain;

import java.sql.Connection;

public interface SubjectRepository {
    void insert(Connection connection, Student student);
}

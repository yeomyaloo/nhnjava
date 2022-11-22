package com.nhnacademy.edu.jdbc.mybatis.domain;

import java.sql.Connection;

public interface CourseRepository {
    void insert(Connection connection, Course course);
}

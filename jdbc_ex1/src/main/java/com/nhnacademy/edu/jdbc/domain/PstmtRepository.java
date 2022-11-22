package com.nhnacademy.edu.jdbc.domain;

import java.sql.Connection;

public interface PstmtRepository {


    List<Course> findByAll(Connection connection);
}

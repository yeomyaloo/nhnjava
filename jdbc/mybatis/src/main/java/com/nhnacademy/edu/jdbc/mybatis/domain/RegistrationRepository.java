package com.nhnacademy.edu.jdbc.mybatis.domain;

import java.sql.Connection;
import java.util.List;

public interface RegistrationRepository {

    List<Registration> findAll(Connection connection);
}

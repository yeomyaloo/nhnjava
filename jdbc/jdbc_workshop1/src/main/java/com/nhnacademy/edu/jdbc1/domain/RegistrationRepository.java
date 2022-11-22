package com.nhnacademy.edu.jdbc1.domain;

import java.sql.Connection;
import java.util.List;

public interface RegistrationRepository {

    List<Registration> findAll();
}

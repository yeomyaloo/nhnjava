package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Registration;
import com.nhnacademy.edu.jdbc.domain.RegistrationRepository;
import com.nhnacademy.edu.jdbc.repository.RegistrationRepositoryImpl;
import com.nhnacademy.edu.jdbc.repository.StudentRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class RegistrationMain {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DBUtils.getDataSource().getConnection()) {

            RegistrationRepository registrationRepository = new RegistrationRepositoryImpl();
            registrationRepository.findAll(connection)
                    .stream()
                    .map(Registration::toFormattedString)
                    .forEach(System.out::println);

        }
    }

}
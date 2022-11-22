package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.DBUtils;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcStudentRepository implements StudentRepository {
    @Override
    public List<Student> findAll(Connection connection) {

        try (
             Statement statement = connection.createStatement();
        ){
            List<Student> result = new ArrayList<>();
            ResultSet rs = statement.executeQuery("select id, name, created_at from JdbcStudents");

            while(rs.next()) {
                result.add(new Student(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getTimestamp(3)
                        ));
            }

            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(Connection connection, Long id) {
        try (
             Statement statement = connection.createStatement();
        ){
            ResultSet rs
                    = statement
                    .executeQuery("select id, name, created_at from JdbcStudents where id ="+ id);

            if(rs.next()) {
                return new Student(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getTimestamp(3)
                );
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Connection connection, Student student) {
        throw new RuntimeException("NOT Implemented!!");
    }

    @Override
    public void updateNameById(Connection connection, Long id, String name) {
        throw new RuntimeException("NOT Implemented!!");
    }

    @Override
    public void deleteById(Connection connection, Long id) {
        throw new RuntimeException("NOT Implemented!!");
    }
}

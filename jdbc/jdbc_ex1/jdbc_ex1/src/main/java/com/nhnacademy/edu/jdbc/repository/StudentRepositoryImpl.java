package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    @Override
    public List<Student> findAll(Connection connection) {

        try  {
            List<Student> result = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("select id, name, created_at from JdbcStudents");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
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
        try  {

            PreparedStatement statement
                    = connection
                    .prepareStatement("select id, name, created_at from JdbcStudents where id = ?");
            statement.setLong(1, 1L);
            ResultSet rs
                    = statement
                    .executeQuery();

            if (rs.next()) {
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
        try (
                PreparedStatement statement
                        = connection
                        .prepareStatement(
                                "INSERT INTO JdbcStudents (id, name, created_at) VALUES (?,?,?)");
        ) {
            statement.setLong(1, student.getId());
            statement.setString(2, student.getName());
            statement.setTimestamp(3, new Timestamp(student.getCreatedAt().getTime()));

            int rowCount = statement.executeUpdate();
            System.out.println("inserted count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateNameById(Connection connection, Long id, String name) {
        try (
                PreparedStatement statement
                        = connection.prepareStatement("UPDATE JdbcStudents SET name=? WHERE id=?");
        ) {
            statement.setString(1, name);
            statement.setLong(2, id);

            int rowCount = statement.executeUpdate();
            System.out.println("updated count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Connection connection, Long id) {
        try (
                PreparedStatement statement
                        = connection.prepareStatement("DELETE FROM JdbcStudents WHERE id=?")
        ) {
            statement.setLong(1, id);
            int rowCount = statement.executeUpdate();
            System.out.println("deleted count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

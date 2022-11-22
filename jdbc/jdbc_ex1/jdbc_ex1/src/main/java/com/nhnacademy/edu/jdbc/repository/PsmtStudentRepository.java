package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Page;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PsmtStudentRepository implements StudentRepository {

    public Page<Student> findAll(Connection connection, int page, int size) {
        List<Student> students = new ArrayList<>();
        long totalCount = 0L;

        try (PreparedStatement psmt = connection.prepareStatement("SELECT id, name, created_at FROM JdbcStudents ORDER BY id LIMIT ? OFFSET ?")) {
            psmt.setInt(1, size);
            psmt.setInt(2, (page - 1) * size);

            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                students.add(
                        new Student(
                                rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at"))
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement psmt = connection.prepareStatement("SELECT count(*) as cnt FROM JdbcStudents")) {
            ResultSet rs = psmt.executeQuery();

            if (rs.next()) {
                totalCount = rs.getLong("cnt");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Page<>(students, totalCount);
    }

    @Override
    public List<Student> findAll(Connection connection) {
        return null;
    }

    @Override
    public Student findById(Connection connection, Long id) {
        return null;
    }

    @Override
    public void insert(Connection connection, Student student) {

    }

    @Override
    public void updateNameById(Connection connection, Long id, String name) {

    }

    @Override
    public void deleteById(Connection connection, Long id) {

    }
}

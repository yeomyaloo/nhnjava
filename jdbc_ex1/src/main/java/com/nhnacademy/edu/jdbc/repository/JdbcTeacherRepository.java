package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.nhnacademy.edu.jdbc.DBUtils.getConnection;

public class JdbcTeacherRepository implements TeacherRepository {


    @Override
    public List<Teacher> findAll() {

        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Teacher findById(Long id) {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcTeachers WHERE id=" + id);
            if(rs.next()) {
                return new Teacher(rs.getLong(1), rs.getString(2), rs.getTimestamp(3));
            }
            return null;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

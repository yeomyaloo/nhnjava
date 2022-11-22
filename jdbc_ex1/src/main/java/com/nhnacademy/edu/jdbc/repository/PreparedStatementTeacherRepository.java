package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.DBUtils;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PreparedStatementTeacherRepository implements TeacherRepository {
    @Override
    public List<Teacher> findAll() {

        try(Connection connection = DBUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name. create_at from JdbcTeachers where id = ?");
            preparedStatement.setLong(1, 1L);
            ResultSet rs = preparedStatement.executeQuery();


            if(rs.next()){
                new Teacher(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getTimestamp(3)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Teacher findById(Long id) {
        return null;
    }
}

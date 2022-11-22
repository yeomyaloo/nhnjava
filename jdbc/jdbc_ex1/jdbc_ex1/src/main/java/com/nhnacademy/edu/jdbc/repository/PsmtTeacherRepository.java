package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Page;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsmtTeacherRepository implements TeacherRepository {
    @Override
    public void insert(Connection connection, Student student) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO JdbcTeachers (id, name, created_at) values(?,?,?)")){
            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<Teacher> findAll(Connection connection, int page, int size) {

        List<Teacher> teacherList = new ArrayList<>();
        long totalCount = 0L;
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, name, created_at FROM JdbcTeachers ORDER BY id LIMIT ? OFFSET ? ")){
            preparedStatement.setInt(1, size);
            preparedStatement.setInt(2, (page-1)*size);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Teacher teacher = new Teacher(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getDate("created_at"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(PreparedStatement preparedStatement = connection.prepareStatement("Select count(*) as cnt FROM JdbcTeachers")) {


            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                totalCount = rs.getLong("cnt");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return new Page<>(teacherList, totalCount);
    }
}

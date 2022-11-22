package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.DBUtils;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PsmtStudentRepository implements StudentRepository {


    @Override
    public List<Student> findAll(Connection connection) {
        return null;
    }

    @Override
    public Student findById(Connection connection,Long id) {
        return null;
    }

    @Override
    public void insert(Connection connection,Student student) {
        try(
                PreparedStatement statement
                        = connection.prepareStatement(
                                "INSERT INTO JdbcStudnets(id,name, created_at) Values (?,?,?");
                ){
            statement.setLong(1, student.getId());
            statement.setString(2, student.getName());
            statement.setTimestamp(3, new TimeStamp(student.getCreatedAt().getTime()));

            int rowCount = statement.executeUpdate();
            System.out.println("insert count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void update(Connection connection) {



    }

    @Override
    public void delete(Connection connection) {

    }
}

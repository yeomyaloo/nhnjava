package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.DBUtils;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.nhnacademy.edu.jdbc.DBUtils.getConnection;



public class JdbcStudentRepository implements StudentRepository {


    @Override
    public List<Student> findAll(Connection connection) {
        try (
             Statement statement = connection.createStatement();
        ) {
            List<Student> students = new ArrayList<>();
            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcStudents");
            while(rs.next()) {
                students.add(
                        new Student(rs.getLong(1), rs.getString(2), rs.getTimestamp(3))
                );
            }
            return students;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findById(Connection connection,Long id) {
        try (
             Statement statement = connection.createStatement();
        ) {
            ResultSet rs = statement.executeQuery("SELECT id, name, created_at FROM JdbcStudents WHERE id=" + id);
            if(rs.next()) {
                return new Student(rs.getLong(1), rs.getString(2), rs.getTimestamp(3));
            }
            return null;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Connection connection) {
        try (
                PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcStudents (id, name, created_at) VALUES (?,?,?)");
        ) {
            statement.setLong(1,2L);
            statement.setString(2,"학생2");
            statement.setTimestamp(3, new Timestamp(new Date().getTime()));
            int rowCount = statement.executeUpdate();
            System.out.println("inserted count : " + rowCount);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Connection connection) {
        try (
                PreparedStatement statement = connection.prepareStatement("UPDATE JdbcStudents SET name=? WHERE id=?");
        ) {
            statement.setString(1,"학생3");
            statement.setLong(2,2L);

            int rowCount = statement.executeUpdate();
            System.out.println("updated count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Connection connection) {
        try (
                PreparedStatement statement = connection.prepareStatement("DELETE FROM JdbcStudents WHERE id=?")
        ) {
            statement.setLong(1,2L);
            int rowCount = statement.executeUpdate();
            System.out.println("deleted count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

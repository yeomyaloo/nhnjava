package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;
import com.nhnacademy.edu.jdbc.domain.TeacherRepository;
import com.nhnacademy.edu.jdbc.repository.JdbcStudentRepository;
import com.nhnacademy.edu.jdbc.repository.JdbcTeacherRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {



        loadDriver();
        Connection connection = DBUtils.getDataSource().getConnection();

        StudentRepository studentRepository = new JdbcStudentRepository();
        Student firstStudent = studentRepository.findById(1L);
        List<Student> all = studentRepository.findAll();


        TeacherRepository teacherRepository = new JdbcTeacherRepository();
        teacherRepository.findAll();
        teacherRepository.findById(1L);
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
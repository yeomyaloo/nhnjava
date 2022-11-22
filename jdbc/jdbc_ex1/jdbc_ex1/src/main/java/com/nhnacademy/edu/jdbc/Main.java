package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;
import com.nhnacademy.edu.jdbc.repository.JdbcStudentRepository;
import com.nhnacademy.edu.jdbc.repository.StudentRepositoryImpl;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");

        //loadDriver();

        try(Connection connection = DBUtils.getDataSource().getConnection()) {

            // Statement
            StudentRepository studentRepository = new JdbcStudentRepository();
            List<Student> students = studentRepository.findAll(connection);

            students.forEach(System.out::println);

            Student firstStudent = studentRepository.findById(connection, 1L);
            System.out.println(firstStudent);


            // PreparedStatement
            System.out.println("=============> Prepared!!");
            StudentRepository studentRepository1 = new StudentRepositoryImpl();
            List<Student> students1 = studentRepository1.findAll(connection);

            students1.forEach(System.out::println);

            Student firstStudent1 = studentRepository1.findById(connection, 1L);
            System.out.println(firstStudent1);

            System.out.println("=============> Prepared INSERT !!");
            studentRepository1.insert(connection, new Student(2L, "학생2", new Date()));
            studentRepository1.findAll(connection).forEach(System.out::println);


            System.out.println("=============> Prepared UPDATE !!");
            studentRepository1.updateNameById(connection, 2L, "학생3");
            studentRepository1.findAll(connection).forEach(System.out::println);


            System.out.println("=============> Prepared DELETE !!");
            studentRepository1.deleteById(connection, 2L);
            studentRepository1.findAll(connection).forEach(System.out::println);

        }
    }

    private static void loadDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
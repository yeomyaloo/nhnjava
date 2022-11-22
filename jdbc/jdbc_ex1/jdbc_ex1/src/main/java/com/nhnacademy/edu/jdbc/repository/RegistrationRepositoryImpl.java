package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationRepositoryImpl implements RegistrationRepository {

    @Override
    public List<Registration> findAll(Connection connection) {
        try {
            PreparedStatement psmt = connection.prepareStatement(
                    "SELECT r.id as r_id, r.score as r_score, r.created_at as r_created_at," +
                            "        c.id as c_id, c.teacher_id , c.subject_id, c.created_at as c_created_at," +
                            "        s.id as s_id, s.name as s_name, s.created_at as s_created_at," +
                            "        st.id as st_id, st.name as st_name, st.created_at as st_created_at," +
                            "        t.id as t_id, t.name as t_name, t.created_at as t_created_at" +
                            "        FROM JdbcRegistrations as r \n" +
                            "        INNER JOIN JdbcCourses as c ON r.course_id = c.id" +
                            "        INNER JOIN JdbcStudents as st ON r.student_id = st.id" +
                            "        INNER JOIN JdbcSubjects as s ON c.subject_id = s.id" +
                            "        INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id;");

            ResultSet resultSet = psmt.executeQuery();

            List<Registration> registrationList = new ArrayList<>();
            while (resultSet.next()) {
                Subject subject = new Subject(
                        resultSet.getLong("s_id"),
                        resultSet.getString("s_name"),
                        resultSet.getDate("s_created_at"));

                Teacher teacher = new Teacher(
                        resultSet.getLong("t_id"),
                        resultSet.getString("t_name"),
                        resultSet.getDate("t_created_at"));

                Course course = new Course(
                        resultSet.getLong("c_id"),
                        subject,
                        teacher,
                        resultSet.getDate("c_created_at"));

                Student student = new Student(
                        resultSet.getLong("st_id"),
                        resultSet.getString("st_name"),
                        resultSet.getDate("st_created_at"));

                registrationList.add(
                        new Registration(resultSet.getLong("r_id"),
                                course,
                                student,
                                resultSet.getLong("r_score"),
                                resultSet.getDate("r_created_at")
                        ));
            }

            return registrationList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
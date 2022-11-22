package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.course.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcCourseRepository implements CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCourseRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Course insert(Subject subject, Teacher teacher) {

        String SQL = "INSERT INTO teacher_id, subject_id, created_at Valuse(?,?,?)";

        return this.jdbcTemplate.queryForObject(SQL,
                (resutSelt,rowNum) ->
                        new Course(subject,
                        teacher,
                        resutSelt.getTimestamp("created_at")));

    }

    @Override
    public void delete() {
        this.jdbcTemplate.update("DELETE id,teacher_id,subject_id,created_at from JdbcCourses");
    }

    @Override
    public List<Course> findAllCourse() {

        String SQL = "SELECT c.id as c_id, c.teacher_id , c.subject_id, c.created_at as c_created_at, \n" +
                "s.id as s_id, s.name as s_name, s.created_at as s_created_at, \n" +
                "t.id as t_id, t.name as t_name, t.created_at as t_created_at \n" +
                "FROM JdbcCourses as c \n" +
                "INNER JOIN JdbcSubjects as s ON c.subject_id = s.id \n" +
                "INNER JOIN JdbcTeachers as t ON c.teacher_id = t.id";

        return this.jdbcTemplate.query(SQL, (rs, rowNum) ->
                        new Course(rs.getLong("c_id"),
                                new Subject(rs.getLong("s_id"),
                                        rs.getString("s_name"),
                                        rs.getTimestamp("s_created_at")),
                                new Teacher(rs.getLong("t_id"),
                                        rs.getString("t_name"),
                                        rs.getTimestamp("t_created_at")),
                                rs.getTimestamp("c_created_at")));
    }

    @Override
    public User findById(Long id) {
        return this.jdbcTemplate.queryForObject(
                "select id, subject_id, teacher_id, created_at from JdbcCourses where id = ?",
                (resultSet,rowNum) -> new User(resultSet.getLong("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password"),
                        resultSet.getDate("created_at"))
                ,id);

    }
}

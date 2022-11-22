package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.course.Course;

import java.util.List;

public interface CourseRepository {
    Course insert(Subject subject, Teacher teacher);
    void delete();
    List<Course> findAllCourse();

    User findById(Long id);

}

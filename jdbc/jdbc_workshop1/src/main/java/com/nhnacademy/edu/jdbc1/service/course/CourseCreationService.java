package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;

import java.util.List;

public interface CourseCreationService {

    void createCourse(Subject subject, Teacher teacher);
    List<Course> getCourseList();
    Course getCourse(Long id);

    void deleteCourse(Long id);

}

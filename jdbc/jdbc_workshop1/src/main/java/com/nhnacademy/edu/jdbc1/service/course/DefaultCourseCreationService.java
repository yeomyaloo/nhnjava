package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.exception.CourseNullException;
import com.nhnacademy.edu.jdbc1.repository.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class DefaultCourseCreationService implements CourseCreationService {
    private final CourseRepository courseRepository;

    public DefaultCourseCreationService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    @Transactional
    public void createCourse(Subject subject, Teacher teacher) {
        try {
            courseRepository.insert(subject, teacher);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Course> getCourseList() {
        return courseRepository.findAllCourse();
    }

    @Override
    public Course getCourse(Long id) {
        return null;
    }


    @Override
    @Transactional
    public void deleteCourse(Long id) {
        try{

        }



    }
}

package com.nhnacademy.edu.jdbc.spring.repository;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.util.List;

public interface SpringTeacherRepository {

    Teacher findById(long id);

    List<Teacher> findAll();

    int insert(Teacher teacher);

    int deleteById(long id);
}

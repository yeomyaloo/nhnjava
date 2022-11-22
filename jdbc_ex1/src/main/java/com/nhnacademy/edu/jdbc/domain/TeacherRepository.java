package com.nhnacademy.edu.jdbc.domain;

import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll();
    Teacher findById(Long id);
    int updateNameById(Long id, String name);
    int insert(Teacher teacher);
    int deleteById(Long id);
}

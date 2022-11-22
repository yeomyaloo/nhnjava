package com.nhnacademy.edu.jdbc.spring.service;


import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.spring.repository.SpringTeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;
import java.util.Objects;

@Service
public class JdbcTemplateTeacherService implements TeacherService {
    private final SpringTeacherRepository teacherRepository;

    public JdbcTemplateTeacherService(SpringTeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher getTeacher(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }


    @Transactional
    @Override
    public void insertAndDelete(Teacher teacher) {
        teacherRepository.insert(teacher);
        if(teacher.getId() == 10L){
            throw new RuntimeException("intended error!!");

        }
        teacherRepository.deleteById(teacher.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Teacher teacher) {
        teacherRepository.insert(teacher);
        if(teacher.getId() == 10L){
            throw new RuntimeException("intended error!!");

        }
        teacherRepository.deleteById(teacher.getId());
    }
}

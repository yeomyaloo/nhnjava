package com.nhnacademy.edu.jdbc.spring.service;


import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.StudentRepository;
import com.nhnacademy.edu.jdbc.spring.repository.SpringStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
public class JdbcTemplateStudentService implements StudentService{
    private final SpringStudentRepository studentRepository;

    public JdbcTemplateStudentService(SpringStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Student student) {
        studentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Student student) {
        studentRepository.insert(student);
        if (student.getId() == 10L) {
            throw new RuntimeException("intended error!!");
        }
        studentRepository.deleteById(student.getId());
    }
}

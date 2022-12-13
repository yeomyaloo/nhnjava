package com.nhnacademy.edu.springboot.student.service;


import com.nhnacademy.edu.springboot.student.domain.StudentRepository;
import com.nhnacademy.edu.springboot.student.model.Student;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NhnStudentService implements StudentService{



    private final StudentRepository studentRepository;

    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }


    //ExceptionHandling -> ControllerAdvice
    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("no student of " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Student createStudent(@NonNull Student student) {

        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }


}

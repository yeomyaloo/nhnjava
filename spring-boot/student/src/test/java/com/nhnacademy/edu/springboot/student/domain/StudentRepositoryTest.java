package com.nhnacademy.edu.springboot.student.domain;

import com.nhnacademy.edu.springboot.student.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() {
        //given
        Student zbum = new Student(1L, "Manty", 10);
        studentRepository.save(zbum);

        //when
        Optional<Student> actual = studentRepository.findById(1L);

        //then
        assertThat(actual).isPresent();
        assertThat(actual.get().getName()).isEqualTo("Manty");


    }
}
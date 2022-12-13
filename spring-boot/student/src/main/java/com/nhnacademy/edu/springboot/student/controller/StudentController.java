package com.nhnacademy.edu.springboot.student.controller;

import com.nhnacademy.edu.springboot.student.model.Student;
import com.nhnacademy.edu.springboot.student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id){
        return studentService.getStudent(id);
    }


    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }
}

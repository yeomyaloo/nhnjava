package com.nhnacademy.springmvc.controller;


import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.exception.NotFoundStudentException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/students")
@RestController
public class RestApiController {

    private final StudentRepository studentRepository;

    public RestApiController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @GetMapping("/{studentId}")
    public Student registerStudentViewController(@PathVariable("studentId") long studentId){
        return studentRepository.getStudent(studentId);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerStudentController(@RequestBody StudentRegister studentRegister, Model model){
        Student student = studentRepository.register(studentRegister.getName(),studentRegister.getEmail(), studentRegister.getScore(), studentRegister.getComment());
        model.addAttribute("student", student);
        return ResponseEntity.created(URI.create("/result")).body(student);
    }


    @PutMapping("/{studentId}/modify")
    public ResponseEntity<?> modifyStudentController(@RequestBody StudentRegister studentRegister,
                                          @PathVariable("studentId") long studentId){
        Student student = studentRepository.modify(studentId, studentRegister.getName(), studentRegister.getEmail(), studentRegister.getScore(), studentRegister.getComment());
        return ResponseEntity.created(URI.create("/modifyResult")).body(student);
    }




}

package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student/register")
public class StudentRegisterController {
    private final StudentRepository studentRepository;

    public StudentRegisterController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String studentRegisterForm() {
        return "studentRegister";
    }

    @PostMapping
    public ModelAndView registerStudent(@ModelAttribute StudentRegister studentRegister, Model model) {
        ModelAndView modelAndView = new ModelAndView("studentView");
        Student student = studentRepository.register(studentRegister.getName(),studentRegister.getEmail(), studentRegister.getScore(), studentRegister.getComment());
        modelAndView.addObject("student", student);
        return modelAndView;
    }


}

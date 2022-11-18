package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.domain.StudentRegister;
import com.nhnacademy.springmvc.exception.NotFoundStudentException;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Objects;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ModelAttribute("student")
    public Student getStudent(@PathVariable("studentId") long studentId){
         Student student = studentRepository.getStudent(studentId);
        if(!studentRepository.exists(studentId)){
            throw new NotFoundStudentException();
        }
        return student;
    }

    @GetMapping("/{studentId}")
    public String viewStudent(){
        return "studentView";
    }

    @GetMapping("/{studentId}/modify")
    public String studentModifyForm() {
        return "studentModify";
    }

    @PostMapping("/{studentId}/modify")
    public String modifyUser(@ModelAttribute StudentRegister studentRegister,
                             @PathVariable("studentId") long studentId,
                             ModelMap modelMap) {

        modelMap.put("student", studentRepository.modify(studentId, studentRegister.getName(), studentRegister.getEmail(), studentRegister.getScore(), studentRegister.getComment()));
        return "studentView";
    }

    @GetMapping(value = "/{studentId}", params ="hideScore=YES")
    public String hideScore(){
        return "studentHideView";
    }

    @ExceptionHandler(NotFoundStudentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNotFoundStudentException(Model model, NotFoundStudentException e) {
        model.addAttribute("exception", e);
        return "error";
    }


}

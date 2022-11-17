package com.nhnacademy.springmvc.controllor;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springmvc.controller.RestApiController;
import com.nhnacademy.springmvc.domain.Student;
import com.nhnacademy.springmvc.repository.StudentRepository;
import com.nhnacademy.springmvc.repository.StudentRepositoryImpl;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("RestApiControllerTest")
class RestApiControllerTest {

    private MockMvc mockMvc;
    private StudentRepository studentRepository;

    private ObjectMapper objectMapper= new ObjectMapper();

    @BeforeEach
    void setUp() {
        studentRepository = mock(StudentRepository.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new RestApiController(studentRepository))
                .defaultRequest(get("/students").accept(MediaType.APPLICATION_JSON))
                .addFilters(new CharacterEncodingFilter("utf-8",true))
                .build();
    }


    @Test
    void registerStudentViewController() throws Exception {


        Student student = new Student(1,"hi", "hi@mail.com", 1, "bad");
        when(studentRepository.register("hi", "hi@mail.com", 1, "bad")).thenReturn(student);

        String uri = "/students/" + student.getId();
        mockMvc.perform(MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    void registerStudentController() throws Exception {
        Student student = new Student(2, "yaloo", "yeomyaloo@naver.com", 55, "so so~");
        when(studentRepository.register("yaloo", "yeomyaloo@naver.com", 55, "so so~")).thenReturn(student);

        mockMvc.perform(post("/students/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.name").value("yaloo"))
                .andExpect(jsonPath("$.email").value("yeomyaloo@naver.com"))
                .andExpect(jsonPath("$.score").value(55))
                .andExpect(jsonPath("$.comment").value("so so~"));
    }

    @Test
    void modifyStudentController() throws Exception {
        Student student = new Student(1, "before", "before@naver.com", 0, "so bad");
        when(studentRepository.register("before", "before@naver.com", 0, "so bad")).thenReturn(student);

        student = new Student(1, "after", "after@mail.com",99,"so good");
        when(studentRepository.modify(1, "after", "after@mail.com",99,"so good")).thenReturn(student);

        String url = "/students/1/modify";

        mockMvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andDo(print())
                .andExpect(jsonPath("$.name").value("after"))
                .andExpect(jsonPath("$.email").value("after@mail.com"))
                .andExpect(jsonPath("$.score").value(99))
                .andExpect(jsonPath("$.comment").value("so good"));

    }

}

package com.nhnacademy.edu.restapi_final_project.controller;

import com.nhnacademy.edu.restapi_final_project.service.EmployeeDepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class RestApiControllerTest {

    @MockBean
    private EmployeeDepartmentService employeeDepartmentService;
    private MockMvc mvc;

    @BeforeEach
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new RestApiController(employeeDepartmentService))
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @DisplayName("회사 직원, 부서 정보 조회")
    @Test
    public void searchDepartmentEmployee() throws Exception {
        mvc.perform(get("/department-members/L1001"))
                .andExpect(status().isOk());
    }


}
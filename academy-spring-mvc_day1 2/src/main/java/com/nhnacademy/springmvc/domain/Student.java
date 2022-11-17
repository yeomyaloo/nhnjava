package com.nhnacademy.springmvc.domain;

import lombok.Data;
import lombok.Setter;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class Student {
    private long id;

    private String name;

    private String email;

    private int score;

    private String comment;


}

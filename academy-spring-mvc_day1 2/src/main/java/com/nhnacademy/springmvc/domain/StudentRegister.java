package com.nhnacademy.springmvc.domain;


import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Value
public class StudentRegister {


    @NotBlank
    @Min(0)
    String name;

    @Email
    String email;

    @Size(min = 0, max = 100)
    int score;

    @NotBlank
    @Size(min = 0, max = 200)
    String comment;


}

package com.nhnacademy.edu.jdbc.domain;

import lombok.Value;

import java.util.Date;


@Value
public class Student {

    private final Long id;
    private final String name;
    private final Date createAt;

    public Student(Long id, String name, Date createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }
}

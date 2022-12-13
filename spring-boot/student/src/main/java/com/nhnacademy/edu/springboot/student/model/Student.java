package com.nhnacademy.edu.springboot.student.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    private long id;
    private String name;
    private Integer score;
}

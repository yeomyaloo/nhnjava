package com.nhnacademy.edu.springboot.student.model;


import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Account {

    @Id
    private Long accountId;
    private String number;
    private Integer balance;

}

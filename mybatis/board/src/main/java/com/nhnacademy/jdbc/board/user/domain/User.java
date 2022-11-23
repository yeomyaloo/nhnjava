package com.nhnacademy.jdbc.board.user.domain;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;



@Getter
public class User {

    private Long id;
    private String name;
    private String password;
    private Date created_at;
    // new sql.Date(util.Date().getTime());



}

package com.nhnacademy.edu.jdbc1.domain;


import lombok.Getter;
import lombok.Value;

import java.sql.Date;

@Getter
@Value
public class User {

    private final Long id;
    private final String userName;
    private final String password;
    private final Date create_at;


}

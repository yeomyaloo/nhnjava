package com.nhnacademy.edu.domain;

import lombok.AllArgsConstructor;


public interface User {


    String getPassword();
    String getName();
    String getId();



    User create(String id, String pwd);

}

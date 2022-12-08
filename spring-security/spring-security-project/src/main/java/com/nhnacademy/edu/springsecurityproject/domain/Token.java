package com.nhnacademy.edu.springsecurityproject.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Token {
    String accessToken;
    String scope;
    String token_type;
}

package com.nhnacademy.edu.springsecurityproject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Token {

    @JsonProperty("access_token")
    String accessToken;
    String scope;
    @JsonProperty("token_type")
    String tokenType;
}

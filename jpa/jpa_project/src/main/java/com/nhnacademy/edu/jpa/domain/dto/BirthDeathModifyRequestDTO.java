package com.nhnacademy.edu.jpa.domain.dto;

import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

@Getter
public class BirthDeathModifyRequestDTO {

    @Nullable
    String email;
    @NotNull
    String phoneNumber;
}

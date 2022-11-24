package com.nhnacademy.jdbc.board.board.domain;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Singular;
import lombok.Value;

@Value
public class CreateRequestBoard {

    @NotNull
    private String title;

    @Size(min = 0, max = 2000)
    private String content;


}

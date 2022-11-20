package com.nhnacademy.edu.domain;

import lombok.Value;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Value
public class PostWriteRequest {
    @NotNull
    @Size(min = 2, max = 200)
    private String title;

    private PostCategory postCategory;

    @NotNull
    @Size(min = 0, max = 20_000)
    private String content;

}

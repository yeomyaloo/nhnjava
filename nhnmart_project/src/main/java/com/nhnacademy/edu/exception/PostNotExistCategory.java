package com.nhnacademy.edu.exception;

public class PostNotExistCategory extends RuntimeException {

    public PostNotExistCategory() {
        super("해당하는 카테고리의 ");
    }
}

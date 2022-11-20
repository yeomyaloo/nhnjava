package com.nhnacademy.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@AllArgsConstructor
public class Post {


    private long postCnt;

    private final String title;
    private final PostCategory postCategory;

    private final String content;

    private User userId;

    private LocalDate localDate;
    private boolean isCheck;


    public Post(long postCnt,String title, PostCategory postCategory, String content) {
        this.postCnt = postCnt;
        this.title = title;
        this.postCategory = postCategory;
        this.content = content;
        this.userId = getUserId();
        this.localDate = LocalDate.now();
        this.isCheck = false;
    }

    public Post(String title, PostCategory postCategory, String content) {
        this.title = title;
        this.postCategory = postCategory;
        this.content = content;
    }

    public Post(long postCnt, String title, PostCategory postCategory, String content, String id, LocalDate localDate, boolean isCheck) {
        this.postCnt = postCnt;
        this.title = title;
        this.postCategory = postCategory;
        this.content = content;
        this.userId = getUserId();
        this.localDate = localDate;
        this.isCheck = isCheck;
    }



}

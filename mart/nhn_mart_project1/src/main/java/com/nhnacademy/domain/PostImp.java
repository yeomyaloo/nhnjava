package com.nhnacademy.domain;

import com.nhnacademy.repository.ArrayUserRepository;
import com.nhnacademy.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class PostImp implements Post{


    long boardId;
    String title;
    String content;
    String id;
    LocalDateTime create_post;
    int viewCnt;


    public PostImp(long boardId, String title, String content, String id, LocalDateTime create_post, int viewCnt) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.id = id;
        this.create_post = create_post;
        this.viewCnt = viewCnt;
    }

    @Override
    public long getId() {
        return this.boardId;
    }

    @Override
    public void setId(Long id) {
        this.boardId = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getWriterUseId() {

        return id;
    }

    @Override
    public void setWriterUserId(String writerUserId) {
        this.id = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return this.create_post;
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        this.create_post = writeTime;
    }

    @Override
    public int getViewCount() {
        return this.viewCnt;
    }

    @Override
    public void increaseViewCount() {
        ++this.viewCnt;
    }
}

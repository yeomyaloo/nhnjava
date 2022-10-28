package com.nhnacademy.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Post {


    long getId();
    void setId(Long id);

    String getTitle();
    void setTitle(String title);

    String getContent();
    void setContent(String content);

    String getWriterUseId();
    void setWriterUserId(String writerUserId);

    LocalDateTime getWriteTime();
    void setWriteTime(LocalDateTime writeTime);

    int getViewCount();
    void increaseViewCount();



}

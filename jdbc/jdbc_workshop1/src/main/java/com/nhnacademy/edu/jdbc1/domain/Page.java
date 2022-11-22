package com.nhnacademy.edu.jdbc1.domain;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final long totalCount;

    public Page(List<T> content, long totalCount) {
        this.content = content;
        this.totalCount = totalCount;
    }

    public List<T> getContent() {
        return content;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
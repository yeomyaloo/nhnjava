package com.nhnacademy.repository;

import com.nhnacademy.domain.Post;

import java.time.LocalDateTime;
import java.util.List;

public class MapPostRepository implements PostRepository{

    private long postId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Override
    public long register(Post post) {
        return 0;
    }

    @Override
    public void modify(Post post) {
    }

    @Override
    public Post remove(long id) {
        return null;
    }

    @Override
    public Post getPost(long id) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }
}

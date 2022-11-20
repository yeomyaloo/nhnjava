package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.Post;
import com.nhnacademy.edu.domain.PostCategory;
import com.nhnacademy.edu.domain.User;

import java.util.List;
import java.util.Map;

public interface PostRepository {

    public Post registerPost(String title, PostCategory postCategory, String content);
    public Post getPost(long postNumber);

    public Map<Long, Post> getPosts();
    public Post modifyPost(Post post);


    public boolean exist(long id);


}

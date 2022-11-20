package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.Post;
import com.nhnacademy.edu.domain.PostCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryImplTest {

    private PostRepository postRepository;

    @BeforeEach
    void setUp() {

        PostRepository postRepository = new PostRepositoryImpl();
    }

    @Test
    void newPostTest(){

        Post post = postRepository.registerPost("test1", PostCategory.불만_접수, "불만을 접수합니다.");


        assertEquals(post.getPostCnt(),1);
    }
}
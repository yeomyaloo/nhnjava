package com.nhnacademy.edu.repository;

import com.nhnacademy.edu.domain.Post;
import com.nhnacademy.edu.domain.PostCategory;
import com.nhnacademy.edu.domain.User;
import com.nhnacademy.edu.exception.PostNotExistException;
import com.nhnacademy.edu.exception.PostNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepositoryImpl implements PostRepository{
    private Map<Long, Post> postMap = new HashMap<>();
    private long postCnt = 1;

    @Override
    public Post registerPost(String title, PostCategory postCategory, String content) {

        Post post = new Post(postCnt, title, postCategory, content);
        postMap.put(postCnt,post);
        ++postCnt;

        return post;


    }

    @Override
    public Post getPost(long postNumber) {
        if(exist(postNumber)) {
            return postMap.get(postNumber);
        }
        throw new PostNotFoundException();
    }

    @Override
    public Map<Long, Post> getPosts() {
        return postMap;
    }


    //해당 포스트 넘버를 기준으로 게시글이 있다면 이를 새로운 번호를 부여해서 생성해주고 없으면 예외처리
    @Override
    public Post modifyPost(Post post) {
        if (!exist(post.getPostCnt())){
            throw new PostNotExistException();
        }
        Post modifyPost = new Post(postCnt, post.getTitle(), post.getPostCategory(), post.getContent(), post.getUserId().getId(),post.getLocalDate(), post.isCheck());

        return modifyPost;
    }

    @Override
    public boolean exist(long postNumber) {

        return postMap.containsKey(postNumber);
    }
}

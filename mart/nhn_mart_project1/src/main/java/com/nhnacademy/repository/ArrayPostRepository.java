package com.nhnacademy.repository;

import com.nhnacademy.domain.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArrayPostRepository implements PostRepository{

    List<Post> postList = new ArrayList<>();


    private long postId;
    private String title;
    private String content;

    private String id;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Override
    public long register(Post post) {
        for (Post forPost: postList){
            if(forPost.getId() == post.getId()){
                postList.add(post);
                return post.getId();
            }
        }
        return post.getId();
    }

    @Override
    public void modify(Post post) {
        post.setId(this.postId);
        post.setTitle(this.title);
        post.setContent(this.content);
        post.setWriteTime(this.modifiedDate);
    }

    @Override
    public Post remove(long id) {
        Post delPost = null;

        for (Post post : postList){
            if(post.getId() == id){
                delPost = post;
            }
        }

        if (delPost == null){
            System.out.println("해당 게시물을 삭제하고자 찾는 아이디가 없습니다.");
        } else{
            postList.remove(delPost);
        }
        return delPost;
    }

    @Override
    public Post getPost(long id) {
        for(Post post: postList){
            if (post.getId() == id){
                return post;
            }
        }
        return null;
    }


    public Boolean isPost(long id){
        for(Post post: postList){
            if(post.getId() == id){
                return true;
            }
        }
        return false;

    }

    @Override
    public List<Post> getPosts() {
        return postList;
    }
}

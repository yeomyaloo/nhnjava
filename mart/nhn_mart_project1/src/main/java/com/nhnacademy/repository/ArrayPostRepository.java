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
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Override
    public long register(Post post) {
        if(!isPost(post.getId())){
            postList.add(post);
        }else {
            System.out.println("해당 번호로 게시글이 작성되었습니다.");
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

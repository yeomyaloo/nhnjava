package com.nhnacademy.edu.domain;

public enum PostCategory {
    불만_접수("불만 접수"),
    제안("제안"),
    환불_교환("환불과 교환"),
    칭찬해요("칭찬해요"),
    기타문의("기타 문의");

    private String postCategory;
    PostCategory(String s) {
        this.postCategory = s;
    }

    public String getPostCategory() {
        return postCategory;
    }
}


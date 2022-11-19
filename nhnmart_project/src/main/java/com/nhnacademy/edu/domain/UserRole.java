package com.nhnacademy.edu.domain;

public enum UserRole {
    ADMIN("admin"),
    CUSTOMER("customer");

    private String authority;


    UserRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}

package com.nhnacademy.domain;

public class UserImp implements User{
    private String id;
    private String password;
    private String name;
    private String profile;


    public UserImp(String id, String password, String name, String profile) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.profile = profile;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.profile;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profile = profileFileName;
    }
}

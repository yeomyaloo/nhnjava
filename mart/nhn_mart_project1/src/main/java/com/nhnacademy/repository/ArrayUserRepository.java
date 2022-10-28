package com.nhnacademy.repository;

import com.nhnacademy.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayUserRepository implements UserRepository {
    List<User> list = new ArrayList<>();



    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void modify(User user) {
        /**
         * 현재 객체를 가져와서 바꾸고자 하는 객체로 setter 사용해서 고쳐줌
         * */
        if(getUser(user.getId()) != null) {
            User currentUser = getUser(user.getId());
            currentUser.setId(user.getId());
            currentUser.setName(user.getName());
            currentUser.setPassword(user.getPassword());
        }
    }

    @Override
    public User remove(String id) {
        Iterator iterator = list.iterator();

        while (iterator.hasNext()){
            User user = (User) iterator.next();
            if (user.getId().equals("id")){
                return user = null;
            }
        }
        return null;
    }

    @Override
    public User getUser(String id) {
        for (User user : list){
            if(user.getId().equals("id")){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return list;
    }
}

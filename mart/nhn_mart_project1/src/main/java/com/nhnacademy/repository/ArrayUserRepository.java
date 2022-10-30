package com.nhnacademy.repository;

import com.nhnacademy.domain.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayUserRepository implements UserRepository {
//    private static UserRepository userRepository = new ArrayUserRepository();
//    public ArrayUserRepository() {
//
//    }
//    public static UserRepository getInstance(){
//        return userRepository;
//    }


    public List<User> list = new ArrayList<>();

    @Override
    public void add(User user) {
        list.add(user);
    }

    @Override
    public void modify(User user) {
        /**
         * 현재 객체를 가져와서 바꾸고자 하는 객체로 setter 사용해서 고쳐줌
         * */

        for(User users : list){
            if (users.getId().equals(user.getId())){
                users.setId(user.getId());
                users.setPassword(user.getPassword());
                users.setName(user.getName());
                users.setProfileFileName(user.getProfileFileName());
            }
        }

    }

    @Override
    public User remove(String id) {
        User delUser = null;
        for(User user : list){
            if (user.getId().equals(id)){
                delUser = user;
                list.remove(user);
            } else {
                System.out.println("삭제하고자 하는 사용자를 찾을 수 없습니다.");
            }
        }
        return delUser;
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

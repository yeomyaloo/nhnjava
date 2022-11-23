package com.nhnacademy.jdbc.board.user.mapper;

import com.nhnacademy.jdbc.board.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface UserMapper {

    Optional<User> selectUser(long id);
    List<User> selectUsers();
    void insertUser(User user);
//    void updateNameById(long id);
//    void updatePasswordById(String name, String password, long id);
    void deleteById(long id);
    Optional<User> selectUserByName(String username);

//    boolean matchesIdAndPassword(String username, String password);


}

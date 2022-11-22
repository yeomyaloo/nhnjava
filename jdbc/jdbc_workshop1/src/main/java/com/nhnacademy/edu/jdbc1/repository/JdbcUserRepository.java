package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcUserRepository implements UserRepository {
    List<User> userList = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public User findByUserName(String userName) {

        return this.jdbcTemplate.queryForObject(
                "select id, userName, password,created_at from JdbcUsers where userName = ?",
                (resultSet,rowNum) -> new User(resultSet.getLong("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password"),
                        resultSet.getDate("created_at"))
                ,userName);

    }


    @Override
    public void insert(User user) {

        this.jdbcTemplate.update("insert into JdbcUsers(id,userName,password,created_at) VALUES(?,?,?,?)",
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getCreate_at());

    }

    @Override
    public List<User> findAll() {
        return this.jdbcTemplate.query(
                "select id, userName,password,created_at from JdbcUsers",
                (resultSet,rowNum) ->
                        new User(resultSet.getLong("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("password"),
                        resultSet.getDate("created_at")));
    }

    @Override
    public int deleteById(Long id) {
        return this.jdbcTemplate.update(
                "DELETE From JdbcUsers WHERE id = ?",
                id);
    }


}

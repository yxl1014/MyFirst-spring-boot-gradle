package com.demo.dao;

import com.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertuser(User user){
        jdbcTemplate.update("insert into test_user(username, password) values (?,?)",
                new Object[]{user.getUsername(),user.getPassword()});
    }

    public User fingbyUsername(String username) {
        User user=jdbcTemplate.queryForObject("select id,username,password from test_user where username=?",User.class,username);
        return user;
    }
}

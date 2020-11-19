package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void add(User user){
        userDao.insertuser(user);
    }

    public User select(String username) {
        return userDao.fingbyUsername(username);
    }
}

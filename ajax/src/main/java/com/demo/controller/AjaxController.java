package com.demo.controller;

import com.demo.entity.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/abc")
    public User index(User user) {
        System.out.println(user.getUsername());
        userService.add(user);
        User u=userService.select(user.getUsername());
        return u;
    }
}

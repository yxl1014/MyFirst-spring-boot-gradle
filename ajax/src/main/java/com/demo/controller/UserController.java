package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    public String add_user(Model model){
        model.addAttribute("host","localhost");
        return "demo";
    }
}

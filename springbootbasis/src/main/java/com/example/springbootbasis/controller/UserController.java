package com.example.springbootbasis.controller;

import com.example.springbootbasis.component.User;
import com.example.springbootbasis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/query/{id}")
    public User query(@PathVariable Long id){
        return userService.query(id);
    }

    @RequestMapping("/save")
    public String save(User user){
        userService.save(user);
        return "success";
    }

    @RequestMapping("/query")
    public List<User> queryInfoByUserName( String userName){
        return userService.queryInfoByUserName(userName);
    }
}

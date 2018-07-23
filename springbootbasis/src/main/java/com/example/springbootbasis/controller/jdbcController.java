package com.example.springbootbasis.controller;

import com.example.springbootbasis.component.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class jdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("get/{id}")
    public User selectUser(@PathVariable Long id){
        return jdbcTemplate.queryForObject("select * from user where id=?",new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    @RequestMapping("/baocun")
    public String saveUser(User user){
        jdbcTemplate.update("insert into user(username,password) values(?,?)",user.getName(),user.getPassword());
        return "success";
    }


}

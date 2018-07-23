package com.example.springbootbasis.service;

import com.example.springbootbasis.component.User;
import com.example.springbootbasis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Cacheable(key = "#id")
    public User query(Long id){
        return userMapper.query(id);
    }

    @CachePut(key = "#user.id")
    public void save(User user){
        userMapper.save(user);
    }

    @Cacheable(key = "#user.userName")
    public List<User> queryInfoByUserName(String userName){
        return userMapper.queryInfoByName(userName);
    }
}

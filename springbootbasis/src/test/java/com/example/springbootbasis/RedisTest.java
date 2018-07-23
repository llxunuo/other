package com.example.springbootbasis;

import com.example.springbootbasis.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    RedisDao redisDao;

    @Test
    public void redisDaoTest(){
        redisDao.setKey("name","hahaha");
        redisDao.setKey("age","16");

        System.out.println(redisDao.getValue("name"));
        System.out.println(redisDao.getValue("age"));
    }
}

package com.example.rediscache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RediscacheApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedisStringTopic(){
        stringRedisTemplate.convertAndSend("string-topic","hello");
    }

    @Test
    public void testOther(){
        stringRedisTemplate.convertAndSend("haha","world");
    }
}

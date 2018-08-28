package com.example.springbootbasis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

public class RedisCacheListener implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void onMessage(Message message, byte[] bytes) {
        Object deserialize = stringRedisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println("接收到的值："+String.valueOf(deserialize));
    }

//    @Override
//    public void onMessage(Message message, byte[] bytes) {
//        Object deserialize = stringRedisTemplate.getValueSerializer().deserialize(message.getBody());
//        System.out.println("接收到的值："+String.valueOf(deserialize));
//    }
}

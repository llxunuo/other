package com.example.rediscache.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;


public class ConsumerRedisListener implements MessageListener {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        doBusiness(message);
    }

    /**
     * 打印接收到的消息
     * @param message
     */
    public void doBusiness(Message message){
        Object value = stringRedisTemplate.getValueSerializer().deserialize(message.getBody());
        System.out.println("consumer message:"+String.valueOf(value));
    }
}

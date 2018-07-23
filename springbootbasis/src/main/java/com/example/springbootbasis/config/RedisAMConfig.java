package com.example.springbootbasis.config;

import com.example.springbootbasis.component.RedisCacheListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisAMConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    public RedisCacheListener redisCacheListener(){
        return new RedisCacheListener();
    }

    public ChannelTopic channelTopic(){
        return new ChannelTopic("redis-topic");
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){

        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        redisMessageListenerContainer.addMessageListener(redisCacheListener(),channelTopic());
        return redisMessageListenerContainer;
    }
}

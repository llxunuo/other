package com.example.rediscache.config;

import com.example.rediscache.listener.ConsumerRedisListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

@Configuration
public class RedisCacheConfig {

//    @Autowired
//    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public ConsumerRedisListener consumerRedisListener(){
        return new ConsumerRedisListener();
    }

    @Bean
    public ChannelTopic topic(){
        return new ChannelTopic("string-topic");
    }

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(consumerRedisListener(),topic());
        return container;
    }

}

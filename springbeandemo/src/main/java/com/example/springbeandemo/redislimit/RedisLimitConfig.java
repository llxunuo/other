package com.example.springbeandemo.redislimit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisCluster;

@Configuration
public class RedisLimitConfig {
    private int limit = 10;

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
//    @Bean
//    public RedisLimit build() {
//        RedisClusterConnection clusterConnection = jedisConnectionFactory.getClusterConnection();
//        JedisCluster jedisCluster = (JedisCluster) clusterConnection.getNativeConnection();
//        RedisLimit redisLimit = new RedisLimit.Builder<>(jedisCluster)
//                .limit(limit)
//                .build();
//        return redisLimit;
//    }

    @Bean
    public RedisLimit build() {
        RedisLimit redisLimit = new RedisLimit.Builder(jedisConnectionFactory, 1)
                .limit(limit)
                .build();
        return redisLimit;
    }
}

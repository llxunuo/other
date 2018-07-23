package com.example.springbootbasis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration
public class SpringbootbasisApplicationTests {

    @Test
    public void contextLoads() {
    }

    @LocalServerPort
    private int port;

    private URL base;

//    @Autowired
    private RestTemplate restTemplate = new RestTemplate();

//    @Bean
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Before
    public void setUp() throws Exception {
        // TODO 因为我们修改了 content-path 所以请求后面要带上
        this.base = new URL("http://localhost:" + port + "/print");
    }

    @Test
    public void demo1() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(base.toString(), String.class);
        assertEquals(response.getBody(), "Hello battcn");
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //测试redis消息队列
    @Test
    public void sendMessage(){
        stringRedisTemplate.convertAndSend("redis-topic","你好！");
    }

}

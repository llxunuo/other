package com.example.rediscache;

import com.example.rediscache.rest.MyRedistest;
import com.example.rediscache.rest.Service;
import com.example.rediscache.rest.ThreadA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RediscacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RediscacheApplication.class, args);

//        分布式锁
//        Service service = new Service();
//        for (int i = 0; i < 50; i++) {
//            ThreadA threadA = new ThreadA(service);
//            threadA.start();
//        }


        //商品秒杀
        MyRedistest mr = new MyRedistest();
        mr.seckill();
    }

}

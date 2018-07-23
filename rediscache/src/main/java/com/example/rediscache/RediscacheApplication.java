package com.example.rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class RediscacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(RediscacheApplication.class, args);
    }
}

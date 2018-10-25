package com.example.springbeandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringbeandemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbeandemoApplication.class, args);
    }

//    @Service
//    public static class SpringLifeCycleService implements InitializingBean,DisposableBean {
//        private final static Logger LOGGER = LoggerFactory.getLogger(SpringLifeCycleService.class);
//        @Override
//        public void afterPropertiesSet() throws Exception {
//            LOGGER.info("SpringLifeCycleService start");
//        }
//
//        @Override
//        public void destroy() throws Exception {
//            LOGGER.info("SpringLifeCycleService destroy");
//        }
//    }


    static List<String> list = new ArrayList<>();

    public static void saveStr(){
        list.add("");
    }
}

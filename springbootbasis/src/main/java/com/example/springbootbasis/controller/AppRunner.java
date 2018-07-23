package com.example.springbootbasis.controller;

import com.example.springbootbasis.service.AsyncTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        Future<String> page1 = asyncTaskService.helloUser("zhangsan");
        Future<String> page2 = asyncTaskService.helloUser("lisi");
        Future<String> page3 = asyncTaskService.helloUser("wangwu");

        while(!(page1.isDone() && page2.isDone() && page3.isDone())){
            Thread.sleep(10);
        }

        logger.info("总耗时: "+(System.currentTimeMillis() - start));
        logger.info("------> " + page1.get());
        logger.info("------> " + page2.get());
        logger.info("------> " + page3.get());
    }
}

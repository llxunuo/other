package com.example.springbootbasis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class AsyncTaskService {

    private RestTemplate restTemplate;

    public AsyncTaskService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public Future<String> helloUser(String name) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println("线程 " + Thread.currentThread().getName());
//        String url = String.format("http://localhost:9100/users/%s",name);
//        String result = restTemplate.getForObject(url, String.class);
        Thread.sleep(1000L);
        System.out.println(name + "执行耗时： "+(System.currentTimeMillis() - start));
//        return new AsyncResult<String>(result);
        return new AsyncResult<String>("");
    }
}

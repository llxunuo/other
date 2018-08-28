package com.example.rpcserver;

import com.example.rpcserver.server.Server;
import com.example.rpcserver.server.impl.ServiceCenter;
import com.example.rpcserver.service.HelloService;
import com.example.rpcserver.service.impl.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RpcserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcserverApplication.class, args);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8011);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

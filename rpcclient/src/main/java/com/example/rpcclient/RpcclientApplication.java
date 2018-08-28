package com.example.rpcclient;

import com.example.rpcclient.client.RPCClient;
import com.example.rpcserver.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;

@SpringBootApplication
public class RpcclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcclientApplication.class, args);

        for (int i=0;i<100;i++){
            HelloService service = RPCClient
                    .getRemoteProxyObj(HelloService.class, new InetSocketAddress("10.10.10.111", 8011));
            System.out.println(service.sayHi("客户端传入的调用参数, ")+i);
        }
    }
}

package com.example.rpcserver.service.impl;

import com.example.rpcserver.service.HelloService;

/**
 * 业务
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHi(String name) {
        return "测试，" + name;
    }
}

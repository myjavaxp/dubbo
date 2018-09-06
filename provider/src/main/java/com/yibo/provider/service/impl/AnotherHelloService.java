package com.yibo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HelloService;

@Service(version = "2.0")
public class AnotherHelloService implements HelloService {
    @Override
    public String hello(String name) {
        if(Math.random()<0.5){
            throw new RuntimeException();
        }
        return "Another: Hello " + name;
    }
}

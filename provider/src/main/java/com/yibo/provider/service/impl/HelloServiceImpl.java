package com.yibo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(version = "1.0")
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(String name) {
        LOGGER.info("接收到参数:" + name);
        if(Math.random()<0.5){
            throw new RuntimeException();
        }
        return "Hello, " + name;
    }
}
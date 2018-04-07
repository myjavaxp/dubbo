package com.yibo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public String hello(String name) {
        LOGGER.info("接收到参数:" + name);
        return "Hello, " + name;
    }
}
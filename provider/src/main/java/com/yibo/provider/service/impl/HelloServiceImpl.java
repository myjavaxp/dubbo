package com.yibo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(
        version = "2.1",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER=LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public String hello(String name) {
        LOGGER.info("接受到参数:"+name);
        return "Hello, " + name;
    }
}
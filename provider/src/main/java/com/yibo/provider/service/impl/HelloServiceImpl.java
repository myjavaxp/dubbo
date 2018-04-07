package com.yibo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HelloService;

@Service(
        version = "2.1",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello, " + name;
    }
}
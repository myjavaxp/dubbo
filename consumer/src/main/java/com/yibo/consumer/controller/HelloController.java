package com.yibo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibo.provider.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference(version = "2.1",
            application = "${dubbo.application.id}",
            group = "1")
    private HelloService helloService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
package com.yibo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yibo.provider.service.HelloService;
import com.yibo.provider.service.HiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Reference
    private HelloService helloService;
    @Reference
    private HiService hiService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return helloService.hello(name);
    }

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable("name")String name){
        return hiService.hi(name);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }
}
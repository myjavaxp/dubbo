package com.yibo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yibo.provider.service.HelloService;
import com.yibo.provider.service.HiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    @Reference(version = "*")
    private HelloService helloService;
    @Reference(stub = "com.yibo.consumer.stub.HiServiceImpl")
    private HiService hiService;

    @GetMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "fallback")
    public Map<String, String> hello(@PathVariable("name") String name) {
        Map<String, String> map = new HashMap<>(1);
        map.put("msg", helloService.hello(name));
        return map;
    }

    @GetMapping("/hi/{name}")
    public Map<String, String> hi(@PathVariable("name") String name) {
        Map<String, String> map = new HashMap<>(1);
        map.put("msg", hiService.hi(name));
        return map;
    }

    @GetMapping("/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>(1);
        map.put("msg", "hello world");
        return map;
    }

    private Map<String, String> fallback(String name) {
        LOGGER.info("传入参数为: [{}]", name);
        Map<String, String> map = new HashMap<>(1);
        map.put("msg", "fallback");
        return map;
    }
}
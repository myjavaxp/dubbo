package com.yibo.anotherprovider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class AnotherProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnotherProviderApplication.class, args);
    }
}
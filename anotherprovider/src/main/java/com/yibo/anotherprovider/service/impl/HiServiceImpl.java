package com.yibo.anotherprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yibo.provider.service.HiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(protocol = "${dubbo.protocol.id}")
public class HiServiceImpl implements HiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HiServiceImpl.class);

    @Override
    public String hi(String name) {
        LOGGER.info("接收到参数:{}", name);
        return "Hi! " + name;
    }
}
package com.yibo.consumer.stub;

import com.yibo.provider.service.HiService;

/**
 * 本地存根
 * 远程服务后，客户端通常只剩下接口，而实现全在服务器端，但提供方有些时候想在客户端也执行部分逻辑。
 * 比如：做 ThreadLocal 缓存，提前验证参数，调用失败后伪造容错数据等等，此时就需要在 API 中带上 Stub
 * 客户端生成 Proxy 实例，会把 Proxy 通过构造函数传给 Stub [1]，然后把 Stub 暴露给用户
 * Stub 可以决定要不要去调 Proxy。
 *
 * @author Yibo
 */
public class HiServiceImpl implements HiService {
    private final HiService hiService;

    public HiServiceImpl(HiService hiService) {
        this.hiService = hiService;
    }

    @Override
    public String hi(String name) {
        if (name.equals("1")) {
            return "容错数据";
        }
        return hiService.hi(name);
    }
}

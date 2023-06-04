package io.github.willwell.dubboblog.dubboasyncprovider.dubbo.service;

import io.github.willwell.dubboblog.dubboasyncprovider.dubbo.api.DemoService;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        String msg = "Hello " + name;
        System.out.println("provider : " + msg);
        return msg;
    }
}
package com.yibaijin.springcloud.service.controller;

import com.yibaijin.springcloud.service.c.service.HelloWorldCService;
import com.yibaijin.springcloud.service.rpc.HelloWorldCClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloWorldController implements HelloWorldCService {

    @Resource
    HelloWorldCClient helloWorldCClient;

    @Value("${management.endpoints.web.exposure.include}")
    String aa;

    @GetMapping("helloworld")
    public String helloWorld() {
        System.out.println(aa);
        String s=helloWorldCClient.hello("world");
        return s;
    }


    @Override
    public String hello(String name) {
        return "hello " + name;
    }
}

package com.yibaijin.springcloud.service.c.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloWorldCService {

    @GetMapping("hello")
    String hello(@RequestParam(name = "name") String name);
}

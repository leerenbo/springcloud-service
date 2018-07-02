package com.yibaijin.springcloud.service.rpc;

import com.yibaijin.springcloud.service.c.service.HelloWorldCService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "service",fallback = HelloWorldCClientFallback.class)
public interface HelloWorldCClient extends HelloWorldCService {

}


@Component
class HelloWorldCClientFallback implements HelloWorldCClient {

    @Override
    public String hello(String name) {
        return "error";
    }
}

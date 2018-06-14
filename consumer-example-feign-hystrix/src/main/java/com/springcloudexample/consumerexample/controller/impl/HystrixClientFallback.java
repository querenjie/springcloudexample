package com.springcloudexample.consumerexample.controller.impl;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback implements MyTestFeignClient {
    @Override
    public String home(String name) {
        return "sorry " + name + ", there must be something wrong during invoking remote service by feign.";
    }
}

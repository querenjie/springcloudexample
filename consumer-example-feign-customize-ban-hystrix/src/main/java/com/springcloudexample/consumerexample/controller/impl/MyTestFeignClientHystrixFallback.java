package com.springcloudexample.consumerexample.controller.impl;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient;
import org.springframework.stereotype.Component;

@Component
public class MyTestFeignClientHystrixFallback implements MyTestFeignClient {
    @Override
    public String home(String name) {
        return "sorry " + name + ", 无法调用到服务。";
    }
}

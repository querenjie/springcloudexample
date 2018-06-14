package com.springcloudexample.consumerexample.controller.impl;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient2;
import org.springframework.stereotype.Component;

@Component
public class MyTestFeignClient2HystrixFallback implements MyTestFeignClient2 {
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "service name(" + serviceName + ") is not able to be contacted for some reason.";
    }
}

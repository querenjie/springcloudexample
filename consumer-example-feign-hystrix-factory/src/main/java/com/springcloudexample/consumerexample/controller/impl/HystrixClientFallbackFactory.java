package com.springcloudexample.consumerexample.controller.impl;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient;
import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClientChild;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<MyTestFeignClient> {
    private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

    @Override
    public MyTestFeignClient create(Throwable throwable) {
        HystrixClientFallbackFactory.LOGGER.info("fallback reason is {}", throwable.getMessage());

        return new MyTestFeignClientChild() {
            @Override
            public String home(String name) {
                return "Dear " + name + ", I'm so sorry to inform you that I'm not able to work normally with provider servide.";
            }
        };
    }
}

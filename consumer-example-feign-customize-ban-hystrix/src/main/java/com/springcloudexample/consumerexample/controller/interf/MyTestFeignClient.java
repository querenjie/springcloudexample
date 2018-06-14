package com.springcloudexample.consumerexample.controller.interf;

import com.springcloudexample.config.MyFeignConfiguration;
import com.springcloudexample.consumerexample.controller.impl.MyTestFeignClientHystrixFallback;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "provider-example1", configuration = MyFeignConfiguration.class, fallback = MyTestFeignClientHystrixFallback.class)
public interface MyTestFeignClient {
    @RequestLine("GET /hi/{name}")
    public String home(@Param("name") String name);
}

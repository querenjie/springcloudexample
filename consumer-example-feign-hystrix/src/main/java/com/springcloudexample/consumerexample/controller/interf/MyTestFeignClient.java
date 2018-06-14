package com.springcloudexample.consumerexample.controller.interf;

import com.springcloudexample.consumerexample.controller.impl.HystrixClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-example1", fallback = HystrixClientFallback.class)
public interface MyTestFeignClient {
    /**
     * 这边要注意的是：
     * 1、必须用@RequestMapping而不能用@GetMapping
     * 2、@PathVariable必须要明确写明参数，不能省略。。
     * @param name
     * @return
     */
    @RequestMapping(value = "hi/{name}", method = RequestMethod.GET)
    public String home(@PathVariable("name") String name);
}


package com.springcloudexample.consumerexample.controller.interf;

import com.springcloudexample.config.MyFeignConfiguration;
import com.springcloudexample.config.MyFeignConfiguration2;
import com.springcloudexample.consumerexample.controller.impl.MyTestFeignClient2HystrixFallback;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "111", url = "http://localhost:8761/", configuration = MyFeignConfiguration2.class, fallback = MyTestFeignClient2HystrixFallback.class)
public interface MyTestFeignClient2 {
    /**
     * serviceName可以用provider-example1
     * @param serviceName
     * @return
     */
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}

package com.springcloudexample.consumerexample.controller;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer001Controller {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private MyTestFeignClient myTestFeignClient;

    @GetMapping("/testLoadBalance")
    public String testLoadBalance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-example1");
        String result = serviceInstance.getHost() + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getPort();
        System.out.println(result);
        return result;
    }

    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        String result = myTestFeignClient.home(name);
        System.out.println(result);
        return result;
    }

}

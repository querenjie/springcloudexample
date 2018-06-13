package com.springcloudexample.consumerexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer001Controller {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/showHi")
    public String getMsg() {
        String result = restTemplate.getForObject("http://provider-example1/hi/querenjie", String.class);
        System.out.println(result);
        return result;
    }

    @GetMapping("/testLoadBalance")
    public String testLoadBalance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider-example1");
        String result = serviceInstance.getHost() + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getPort();
        System.out.println(result);
        return result;
    }
}

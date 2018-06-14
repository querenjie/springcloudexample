package com.springcloudexample.consumerexample.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer001Controller {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * commandProperties的配置将确保getMsg()和getMsgFallBack()在同一个线程中运行
     * @return
     */
    @GetMapping("/showHi")
    @HystrixCommand(fallbackMethod = "getMsgFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")})
    public String getMsg() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = restTemplate.getForObject("http://provider-example1/hi/querenjie", String.class);
        System.out.println(result);
        return result;
    }

    /**
     * 参数和返回值一定要和原来的方法一致的
     * @return
     */
    public String getMsgFallBack() {
        return "fallback of getMsg()";
    }

}

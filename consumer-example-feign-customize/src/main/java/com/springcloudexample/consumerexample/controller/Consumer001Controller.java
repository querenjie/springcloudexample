package com.springcloudexample.consumerexample.controller;

import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient;
import com.springcloudexample.consumerexample.controller.interf.MyTestFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer001Controller {
    @Autowired
    private MyTestFeignClient myTestFeignClient;
    @Autowired
    private MyTestFeignClient2 myTestFeignClient2;

    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        String result = myTestFeignClient.home(name);
        System.out.println(result);
        return result;
    }

    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return myTestFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}

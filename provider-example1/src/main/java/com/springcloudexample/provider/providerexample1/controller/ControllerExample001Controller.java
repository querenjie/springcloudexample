package com.springcloudexample.provider.providerexample1.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.springcloudexample.provider.providerexample1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerExample001Controller {
    @Autowired
    private EurekaClient eurekaClient;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instanceInfo = this.eurekaClient.getNextServerFromEureka("PROVIDER-EXAMPLE1", false);
        return instanceInfo.getHomePageUrl();
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/hi/{name}")
    public String home(@PathVariable String name) {
        System.out.println("hi " + name + ", I'm from port: " + port);
        return "hi " + name + ", I'm from port: " + port;
    }

    @GetMapping("listAllUsers")
    public List<User> listAllUsers() {
        User user1 = new User("001", "John");
        User user2 = new User("002", "York");

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        return userList;
    }
}

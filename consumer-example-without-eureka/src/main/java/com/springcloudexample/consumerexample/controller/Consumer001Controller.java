package com.springcloudexample.consumerexample.controller;

import com.springcloudexample.consumerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/listAllUsers")
    public List<User> listAllUsers() {
        /*************************这种做法是不对的**********************************
        List<User> resultList = new ArrayList<User>();
        List userList = restTemplate.getForObject("http://provider-example1/listAllUsers", List.class);
        if (userList != null && userList.size() > 0) {
            for (int i = 0; i < userList.size(); i++) {
                User user = (User) userList.get(i);
                System.out.println("userId=" + user.getUserId() + ", userName=" + user.getUserName());
                resultList.add(user);
            }
        }
        return resultList;
        ************************************************************************/
        //以下的用法是正确的，但是要注意User类中必须要有默认的构造方法。
        User[] users = restTemplate.getForObject("http://provider-example1/listAllUsers", User[].class);
        List<User> userList = Arrays.asList(users);
        if (userList != null) {
            for (User user : userList) {
                System.out.println("userId=" + user.getUserId() + ", userName=" + user.getUserName());
            }
        }
        return userList;
    }
}

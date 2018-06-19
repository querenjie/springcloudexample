package com.springcloudexample.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableHystrixDashboard
public class ExampleGatewayZuulFallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleGatewayZuulFallbackApplication.class, args);
    }
}

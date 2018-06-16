package com.springcloudexample.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ExampleGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleGatewayZuulApplication.class, args);
    }
}

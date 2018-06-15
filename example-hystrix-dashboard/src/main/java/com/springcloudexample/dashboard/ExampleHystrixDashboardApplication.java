package com.springcloudexample.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ExampleHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleHystrixDashboardApplication.class, args);
    }
}

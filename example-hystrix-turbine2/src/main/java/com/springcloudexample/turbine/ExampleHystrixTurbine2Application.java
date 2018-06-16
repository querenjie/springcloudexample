package com.springcloudexample.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class ExampleHystrixTurbine2Application {

    public static void main(String[] args) {
        SpringApplication.run(ExampleHystrixTurbine2Application.class, args);
    }
}

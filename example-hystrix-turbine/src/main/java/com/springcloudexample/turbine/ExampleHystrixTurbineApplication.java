package com.springcloudexample.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class ExampleHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleHystrixTurbineApplication.class, args);
    }
}

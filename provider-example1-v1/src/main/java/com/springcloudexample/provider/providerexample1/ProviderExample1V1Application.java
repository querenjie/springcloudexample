package com.springcloudexample.provider.providerexample1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderExample1V1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderExample1V1Application.class, args);
    }

}

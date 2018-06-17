package com.springcloudexample.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ExampleGatewayZuulRegExpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleGatewayZuulRegExpApplication.class, args);
    }

    /**
     * 在浏览器地址栏里面输入：http://localhost:8779/v1/provider-example1/hi/querenjie
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}") {
            @Override
            public String apply(final String serviceId) {
                String route =  super.apply(serviceId);
                System.out.println(serviceId + " -> " +route);
                return route;
            }

        };
    }
}

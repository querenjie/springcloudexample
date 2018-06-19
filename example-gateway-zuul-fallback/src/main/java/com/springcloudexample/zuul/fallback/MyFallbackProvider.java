package com.springcloudexample.zuul.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class MyFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        System.out.println("provider-example1");
        return "provider-example1";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                System.out.println("getStatusCode");
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                System.out.println("getRawStatusCode");
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                System.out.println("getStatusText");
                return "OK";
            }

            @Override
            public void close() {
                System.out.println("close");
            }

            @Override
            public InputStream getBody() throws IOException {
                System.out.println("getBody");
                return new ByteArrayInputStream("fallback".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                System.out.println("getHeaders");
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}

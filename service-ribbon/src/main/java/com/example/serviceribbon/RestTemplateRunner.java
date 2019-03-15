package com.example.serviceribbon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateRunner implements CommandLineRunner {

    @Bean
    @LoadBalanced // start load balance
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------------success-------------------------------"); }
}

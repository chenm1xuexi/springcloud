package com.example.eureka_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping(value = "/hello")
public class HelloController {

    @Value("${test.gibson}")
    private String userName;

    @RequestMapping(value = "/hi")
    public String hello() {
        return "Hello, World!!!" + " my name is " + userName;
    }
}

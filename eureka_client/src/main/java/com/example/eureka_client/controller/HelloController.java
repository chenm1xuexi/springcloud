package com.example.eureka_client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/hi")
    public String hello() {
        return "Hello, World!!!";
    }
}

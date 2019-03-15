package com.example.serviceribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable(value = "name") String name) {
        return "Hello " + name;
    }

    @GetMapping(value = "/hello")
    public String getHello() {
        return restTemplate.getForObject("http://DEMO-1/hello/hi", String.class);
    }
}

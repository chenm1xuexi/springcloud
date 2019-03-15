package com.example.servicefeign.controller;

import com.example.servicefeign.feign_service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value ="/hello")
    public String hello() {
        return demoService.sayHello();
    }
}

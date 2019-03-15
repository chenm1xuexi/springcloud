package com.example.servicefeign.feign_service.error_impl;

import com.example.servicefeign.feign_service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceHystrix implements DemoService {
    @Override
    public String sayHello() {
        return "sorry, the service has been trashed";
    }
}

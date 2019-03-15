package com.example.servicefeign.feign_service;

import com.example.servicefeign.feign_service.error_impl.DemoServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "demo-1", fallback = DemoServiceHystrix.class) //pass by @FeignClient("service name") to call special service
public interface DemoService {
    @RequestMapping(value = "/hello/hi", method = RequestMethod.GET)
    String sayHello();
}

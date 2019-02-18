package com.example.serviceribbon.controller;

import com.example.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author pyt
 * @Date 2018/12/26 18:00
 */
@RestController
@EnableHystrixDashboard
public class HelloController {
    @Autowired
    HelloService helloService;
    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}

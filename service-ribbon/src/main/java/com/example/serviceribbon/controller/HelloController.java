package com.example.serviceribbon.controller;

import com.example.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Author pyt
 * @Date 2018/12/26 18:00
 */
@RestController
public class HelloController {
    @Autowired
    HelloService helloService;
    @GetMapping(value = "hi")
    public String hi(@RequestParam String name){
        return helloService.hiService(name);
    }
}

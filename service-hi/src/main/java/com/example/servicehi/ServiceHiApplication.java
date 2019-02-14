package com.example.servicehi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    private static final Logger LOG = LogManager.getLogger(ServiceHiApplication.class);

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "pyt") String name) {
        LOG.info("hi is being called.");
        return "hi " + name + " ,i am from port:" + port;
    }

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "pyt") String name){
        LOG.info("test is being called.");
        return "test!!!This is from port:"+port;
    }
}


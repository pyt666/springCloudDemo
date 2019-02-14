package com.example.servicezipkintest;

import brave.sampler.Sampler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceZipkinTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinTestApplication.class, args);
    }

    private static  final Logger LOG = LogManager.getLogger(ServiceZipkinTestApplication.class);

    @RequestMapping("/hi")
    public String home(){
        LOG.info("Hi is being called.");
        return "Hi！ I'm test.";
    }

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    @RequestMapping("/test")
    public String info(){
        LOG.info("info is being called.");
        return restTemplate.getForObject("http://localhost:8988/info",String.class);
    }
}


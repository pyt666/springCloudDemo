package com.example.servicezipkin;

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
public class ServiceZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZipkinApplication.class, args);
    }

    private static final Logger LOG = LogManager.getLogger(ServiceZipkinApplication.class);

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/hi")
    public String callHome(){
        LOG.info("calling trace service-zipkin  ");
        return restTemplate.getForObject("http://localhost:8989/test",String.class);
    }

    @RequestMapping("/info")
    public String info(){
        LOG.info("calling trace service-zipkin  ");
        return "I'm service-zipkin.";
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

}


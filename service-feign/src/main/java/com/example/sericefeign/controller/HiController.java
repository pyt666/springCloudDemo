package com.example.sericefeign.controller;

import com.example.sericefeign.SchedualServiceHi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName HiController
 * @Author pyt
 * @Date 2018/12/28 18:20
 */
@RestController
public class HiController {
    @Autowired
    private SchedualServiceHi schedualServiceHi;

    private static final Logger LOG = LogManager.getLogger(HiController.class);

   @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        LOG.info("准备消费——hi");
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping("/test")
    public String test(@RequestParam String name){
        LOG.info("准备消费——test");
        return schedualServiceHi.sayTestFromClientOne(name);
    }
}

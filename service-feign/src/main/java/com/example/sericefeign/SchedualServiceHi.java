package com.example.sericefeign;

import com.example.sericefeign.controller.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    String sayTestFromClientOne(@RequestParam(value = "name") String name);
}

package com.example.sericefeign.controller;

import com.example.sericefeign.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @ClassName SchedualServiceHiHystrix
 * @Author pyt
 * @Date 2019/1/2 11:26
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "Sorry " + name;
    }

    @Override
    public String sayTestFromClientOne(String name) {
        return "Sorry " + name;
    }
}

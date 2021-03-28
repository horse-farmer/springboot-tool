package com.horsefarmer.springboottool.controller;

import com.horsefarmer.springboottool.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/25 0:30
 */

@RestController
@RequestMapping("asyn")
public class AsynController {

    @Autowired
    AsynService service;

    @GetMapping("/test")
    public String hello() {
        service.testAsyn();

        return "OK";
    }
}

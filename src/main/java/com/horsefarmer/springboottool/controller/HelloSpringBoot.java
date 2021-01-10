package com.horsefarmer.springboottool.controller;

import com.horsefarmer.springboottool.entity.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/1/9 15:32
 */
@RestController
@RequestMapping("hello")
public class HelloSpringBoot {

    @RequestMapping("/string")
    @ResponseStatus(HttpStatus.OK)
    public String helloString(){
        return "Hello Spring Boot";
    }



    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/json")
    public Message helloJson(){
        return new Message("success","Hello Spring Boot By JSON");
    }
}
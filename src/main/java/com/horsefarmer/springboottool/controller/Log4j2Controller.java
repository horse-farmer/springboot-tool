package com.horsefarmer.springboottool.controller;

import com.horsefarmer.springboottool.SpringbootToolApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/2/4 22:54
 */
@RestController
@RequestMapping("log")
public class Log4j2Controller {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SpringbootToolApplication.class);



    @RequestMapping("test")
    @ResponseStatus(HttpStatus.OK)
    public String helloString(){
        log.trace("trace");
        log.debug("debug");
        log.warn("warn");
        log.info("info");
        log.error("error");
        return "Hello Spring Boot";
    }

}

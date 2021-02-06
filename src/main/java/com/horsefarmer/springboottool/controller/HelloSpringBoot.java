package com.horsefarmer.springboottool.controller;

import com.horsefarmer.springboottool.pojo.Message;
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

    /**
     * hello world返回，最简单类型
     * @return String
     */
    @RequestMapping("/string")
    @ResponseStatus(HttpStatus.OK)
    public String helloString(){
        return "Hello Spring Boot";
    }


    /**
     * 返回对象
     * @return Message
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/json")
    public Message helloJson(){
        return new Message("success","Hello Spring Boot By JSON");
    }


    /**
     * http://localhost:8080/hello/param?username=xiaoxian
     * 请求参数要在url中通过?key=value&key=value形式
     * @param userName 用户名
     * @return Message
     */
    @GetMapping(value = "param")
    public Message param(@RequestParam(value = "userName",defaultValue = "Boot") String userName){
        return new Message("success","Hello "+ userName);
    }


    /**
     * http://localhost:8080/hello/pathValue/xiaoxian
     * 也就是参数是url请求路径的一部分
     * @param userName
     * @return
     */
    @GetMapping(value = "pathValue/{username}")
    public Message getPathValue(@PathVariable(value = "username" ,name = "username",required = true) String userName){
        return new Message("success","Hello "+ userName);
    }


}
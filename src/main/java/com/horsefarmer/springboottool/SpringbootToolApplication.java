package com.horsefarmer.springboottool;

import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author Mr.peng
 * @EnableScheduling 开启定时任务
 * @EnableAsync 开启异步任务
 */
@SpringBootApplication
@EnableScheduling
//@EnableDubboConfig
@EnableAsync
public class SpringbootToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootToolApplication.class, args);
    }

}

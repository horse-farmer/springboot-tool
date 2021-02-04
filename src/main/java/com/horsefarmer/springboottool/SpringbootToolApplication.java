package com.horsefarmer.springboottool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.horsefarmer.springboottool.mapper")
public class SpringbootToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootToolApplication.class, args);
    }

}

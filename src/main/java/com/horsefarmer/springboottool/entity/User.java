package com.horsefarmer.springboottool.entity;

import lombok.Data;

import javax.annotation.Resource;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/1/5 23:32
 */
@Data
@Resource
public class User {
    private String permissions;
}

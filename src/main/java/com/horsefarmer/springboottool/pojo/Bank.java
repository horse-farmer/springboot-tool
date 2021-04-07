package com.horsefarmer.springboottool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/4/7 23:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    /**
     * 银行账户
     */
    private Integer accountNumber;

    /**
     * 余额
     */
    private Integer balance;

    /**
     * 名
     */
    private String firstname;

    /**
     * 姓
     */
    private String lastname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 地址
     */
    private String address;

    /**
     * 职业
     */
    private String employer;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 城市
     */
    private String city;

    /**
     * 州
     */
    private String state;

}

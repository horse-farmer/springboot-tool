package com.horsefarmer.springboottool.controller;

import com.horsefarmer.springboottool.pojo.User;
import com.horsefarmer.springboottool.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/2/4 23:30
 */

@RestController
@RequestMapping("mybatisPlus")
public class MybatisPlusController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("getUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getUsers() {
        return userMapper.selectList(null);
    }
}

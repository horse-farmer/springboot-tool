package com.horsefarmer.springboottool;

import com.horsefarmer.springboottool.pojo.User;
import com.horsefarmer.springboottool.mapper.UserMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class SpringbootToolApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void testSelectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("mrpeng");
        user.setAge(18);
        user.setEmail("123456789@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3L);
        user.setName("大吉大利");
        user.setAge(324);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
}

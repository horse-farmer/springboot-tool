package com.horsefarmer.springboottool;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.horsefarmer.springboottool.mapper.UserMapper;
import com.horsefarmer.springboottool.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/2/24 0:15
 */
@SpringBootTest
public class WrapperTest {


    @Autowired
    UserMapper userMapper;

    @Test
    void testSelectAll() {
        // 参数是一个Wrapper，条件构造器，
        // 查询name不为空，并且邮箱不为空的用户，年龄大于100

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 100);
        List<User> users = userMapper.selectList(wrapper); // 和我们刚才学习的map非常类似
        users.forEach(System.out::println);
    }

    @Test
    public void test2() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "大吉大利");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3() {
        // 查询年龄在22~30岁之间的条数
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",22, 30);
        Integer integer = userMapper.selectCount(wrapper);
        System.out.println(integer);
    }

    // 模糊查询
    @Test
    void test4() {
        // 查询name字段中不包含"B"的以及email字段中不包含t开头信息的数据
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "B")
                .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    // 内敛查询，子查询
    @Test
    void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id>2");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }


    // 测试六
    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过id进行排序
        wrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}

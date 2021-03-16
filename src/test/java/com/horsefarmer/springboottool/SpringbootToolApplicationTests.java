package com.horsefarmer.springboottool;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.horsefarmer.springboottool.pojo.User;
import com.horsefarmer.springboottool.mapper.UserMapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class SpringbootToolApplicationTests {

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
        user.setName("小刘");
        user.setAge(18);
        user.setEmail("123mm6789@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1362772302522470401L);
        user.setName("大吉大利");
        user.setAge(324);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }


    // 测试乐观锁
    // 成功案例：单线程
    @Test
    public void testOptimisticLockerSuccess() {
        // 1、查询用户信息
        User user = userMapper.selectById(2L);
        // 2、修改用户信息
        user.setEmail("haopeng@gmail.com");
        userMapper.updateById(user);
    }

    // 失败案例：多线程
    @Test
    public void testOptimisticLockerFailure() {
        // 1、线程1
        User user = userMapper.selectById(2L);
        user.setEmail("haopeng@gmail.com");
        // 2、线程2插队
        User user2 = userMapper.selectById(2L);
        user2.setEmail("haopeng@gggg.com");
        userMapper.updateById(user2);

        userMapper.updateById(user);// 如果没有乐观锁，就会覆盖插队的值
    }

    // 测试查询操作
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 注意此时可以“不用一定“传入Long型数据
    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2));
        users.forEach(System.out::println);
    }

    // 条件批量查询 map
    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        /*
        注意：map中放入多个值，是取交集：类似where and
         */
        map.put("name", "大吉大利");
        map.put("age", 24);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage() {
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(1, 5);
        // 会先执行 "SELECT COUNT(*) FROM user"，因此效率十分低
        userMapper.selectPage(page, null);
        System.out.println(page.getTotal()); // 6
//        page.getRecords().forEach(System.out::println);
    }

    // 测试删除
    @Test
    public void testDeleteById() {
        // 执行UPDATE user SET is_delete=1 WHERE id=? AND is_delete=0
        // 即执行的是更新操作
        userMapper.deleteById(2L);
    }

    // 批量删除
    @Test
    public void testDeleteByBatchId() {
        userMapper.deleteBatchIds(Arrays.asList(2,3));// 执行DELETE FROM user WHERE id=?
    }

    // 通过map删除
    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Sandy");
        userMapper.deleteByMap(map);// 执行DELETE FROM user WHERE id=?
    }




}

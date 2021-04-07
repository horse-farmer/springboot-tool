package com.horsefarmer.springboottool;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.horsefarmer.springboottool.pojo.User;
import com.horsefarmer.springboottool.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/17 0:18
 */
@SpringBootTest
public class RedisTest {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void contextLoads() {
    //
        // redisTempLate     操作不同类型的数据，api和我们的指令是一样的

        // opsForValue        操作字符串类似     Stringl
        // opsForList         操作List
        // opsForHash         操作Hash
        // opsForGeo          操作地理坐标
        // ....

        // 除了进本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的CRUD

        // 获取redis连接对象，一般很少去用
        /*RedisConnection connection = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection();
        connection.flushDb();
        connection.flushAll();*/


        redisTemplate.opsForValue().set("myKey", "horse");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

/*
    @Test
    public void testSerialize() throws JsonProcessingException {
        User horse = new User(1231234L, "大吉大利", 33, "3ph0512@qq.com", 0, 0, new Date(), new Date());
//        String jsonUser = new ObjectMapper().writeValueAsString(horse);
        redisTemplate.opsForValue().set("user", horse);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
*/


    @Test
    public void testMyRedisUtil() {
        redisUtil.set("name", "qibao");
        System.out.println(redisUtil.get("name"));
    }
}

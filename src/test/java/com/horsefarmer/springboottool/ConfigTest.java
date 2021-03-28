package com.horsefarmer.springboottool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.horsefarmer.springboottool.pojo.ConfigEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/23 23:03
 */

@SpringBootTest
public class ConfigTest {


    @Autowired
    private ConfigEntity entity;

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(entity, SerializerFeature.PrettyFormat));
    }
}

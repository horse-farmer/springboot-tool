package com.horsefarmer.springboottool.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/2/19 22:07
 */
@Slf4j
@Component // 一定不要忘了把处理器加到ioc组件中
public class MyMetaObjectHandler implements MetaObjectHandler {

    // 插入时的填充策略
    @Override
    public void insertFill(MetaObject metaObject) {

        log.info("start insert fill");
        // 第一个参数是对象的属性名，第二个参数是插入值，第三个参数是元数据对象
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtUpdate", new Date(), metaObject);
    }

    // 更新时的填充策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill");
        this.setFieldValByName("gmtUpdate", new Date(), metaObject);
    }
}

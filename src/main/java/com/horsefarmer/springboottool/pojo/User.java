package com.horsefarmer.springboottool.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/1/5 23:32
 */
@Data
@Resource
@AllArgsConstructor
@NoArgsConstructor
public class User {


    // 对应数据库中的主键（uuid，自增ID，雪花算法，redis，zookeeper）
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
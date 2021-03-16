package com.horsefarmer.springboottool.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/1/5 23:32
 */
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    // 对应数据库中的主键（uuid，自增ID，雪花算法，redis，zookeeper）
    // @TableId(type = IdType.)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version // 乐观锁注解@Version
    private Integer version;

    @TableLogic
    private Integer isDelete;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;


}

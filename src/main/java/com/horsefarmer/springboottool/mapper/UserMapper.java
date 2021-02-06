package com.horsefarmer.springboottool.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.horsefarmer.springboottool.pojo.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/2/4 23:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}

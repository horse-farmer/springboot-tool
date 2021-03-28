package com.horsefarmer.springboottool.service.impl;

import com.horsefarmer.springboottool.service.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/27 23:36
 */

@DubboService/*服务注册与发现*/
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "测试分布式！！！";
    }
}

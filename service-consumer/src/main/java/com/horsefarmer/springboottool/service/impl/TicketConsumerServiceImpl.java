package com.horsefarmer.springboottool.service.impl;


import com.horsefarmer.springboottool.service.TicketConsumerService;
import com.horsefarmer.springboottool.service.TicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/29 22:05
 */

@Service
public class TicketConsumerServiceImpl implements TicketConsumerService {

    /*要去注册中心拿provider-service提供的服务，要去注册中心拿*/
    @DubboReference
    TicketService ticketService;

    @Override
    public void buy() {
        System.out.println("我终于买到了一张票--------" + ticketService.getTicket());
    }
}

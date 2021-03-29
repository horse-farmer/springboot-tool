package com.horsefarmer.springboottool;

import com.horsefarmer.springboottool.service.TicketConsumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceConsumerApplicationTests {

    @Autowired
    TicketConsumerService consumerService;

    @Test
    void contextLoads() {
        consumerService.buy();
    }

}

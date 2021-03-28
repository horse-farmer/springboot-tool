package com.horsefarmer.springboottool.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/25 0:31
 */

@Service
public class AsynService {

    @Async
    public void testAsyn() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据正在处理........");
    }

}

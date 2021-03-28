package com.horsefarmer.springboottool.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/3/27 0:53
 */
@Service
public class ScheduledService {


    /*
    网上可以搜索cron表达式生成
    30 15 10 * * ?        每天10x点15分3日执行一次
    30 0/5 10,18 * * ?    每天10点，每隔五分钟执行一次
    0 0/5 10,18 * * ?     每天10点和8点，每隔五分钟执行一次
    15 10 ? * 1-6         每个月的周一到周六10.15分钟执行一A
    0/2 * * * * ?         每2秒执行一次
     */
    // 秒 分 时 日 月 周几
    @Scheduled(cron = "0/2 * * * * ?")
    public void scheduledFun() {
        System.out.println("这个方法被执行了~");
    }
}

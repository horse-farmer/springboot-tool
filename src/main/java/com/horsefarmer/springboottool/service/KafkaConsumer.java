package com.horsefarmer.springboottool.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Description
 * @Author horse-farmer
 * @Date 2021/5/16 13:59
 */

@Component
public class KafkaConsumer {
    private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @KafkaListener(topics = "test_data")
    @SendTo
    public String listen(String input) {
        logger.info("input value: {}", input);
        return "successful";
    }
}
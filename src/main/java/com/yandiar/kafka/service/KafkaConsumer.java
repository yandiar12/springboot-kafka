package com.yandiar.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.yandiar.kafka.payload.User;
import com.yandiar.kafka.utils.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaConsumer {
    
    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void consume(User data) {
        log.info("Message received : {}", data.toString());
    }
}

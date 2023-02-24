package com.yandiar.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.yandiar.kafka.payload.User;
import com.yandiar.kafka.utils.AppConstants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User data) {
        log.info("Message sent -> {}", data.toString());

        Message<User> message = MessageBuilder
            .withPayload(data)
            .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME)
            .build();

        kafkaTemplate.send(message);
    }
}

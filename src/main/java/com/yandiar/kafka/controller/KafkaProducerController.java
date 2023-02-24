package com.yandiar.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandiar.kafka.payload.User;
import com.yandiar.kafka.service.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class KafkaProducerController {
    
    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User data) {
        kafkaProducer.sendMessage(data);
        return ResponseEntity.ok("Message sent to Kafka Topic");
    }
}

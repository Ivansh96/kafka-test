package com.kafkatest.controller;

import com.kafkatest.dto.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
@RequiredArgsConstructor
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    @PostMapping
    public void getMessage(@RequestBody MessageRequest request) {
         kafkaTemplate.send("testTopic", request.message());
    }

}

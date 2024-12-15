package com.madhavsoft.springboot.controller;

import com.madhavsoft.springboot.constants.ApiCostants;
import com.madhavsoft.springboot.dto.User;
import com.madhavsoft.springboot.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private final RabbitMQJsonProducer jsonProducer;

    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping(ApiCostants.SAVE_JSON_MSG)
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user) {
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Message sent over MQ.... ");
    }
}
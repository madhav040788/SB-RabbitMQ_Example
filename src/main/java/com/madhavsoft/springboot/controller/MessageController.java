package com.madhavsoft.springboot.controller;
import com.madhavsoft.springboot.constants.ApiCostants;
import com.madhavsoft.springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")//v1/api/publish
public class MessageController {

    private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @GetMapping(ApiCostants.GET_MSG)
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ... ");
    }
}

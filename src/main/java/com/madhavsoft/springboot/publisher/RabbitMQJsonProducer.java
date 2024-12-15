package com.madhavsoft.springboot.publisher;

import com.madhavsoft.springboot.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonProducer {

  @Value("{rabbitmq.exchange.name}")
  private String exchange;

  @Value("{rabbitmq.json.routing.key}")
  private String routingJsonKey;

  private static final Logger logger = LoggerFactory.getLogger(RabbitMQJsonProducer.class);

  private final RabbitTemplate rabbitTemplate;

  public RabbitMQJsonProducer(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public void sendJsonMessage(User user){
    logger.info(String.format("Send Json message over RabbitMQ ... %s",user.toString()));
    rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
  }

}

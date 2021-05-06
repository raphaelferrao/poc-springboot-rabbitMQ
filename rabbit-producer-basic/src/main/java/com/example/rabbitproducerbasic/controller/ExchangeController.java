package com.example.rabbitproducerbasic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitproducerbasic.model.Person;

@RestController
@RequestMapping("exchanges")
public class ExchangeController {

	private static final Logger log = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping("{exchange}/{routingKey}")
    public HttpEntity<?> postOnExchange(
        @PathVariable String exchange,
        @PathVariable String routingKey,
        @RequestBody String message) {
		
        log.info("sending message {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }

    @PostMapping("json/{exchange}/{routingKey}")
    public HttpEntity<?> postJsonOnExchange(
        @PathVariable String exchange,
        @PathVariable String routingKey,
        @RequestBody Person message) {
    	
    	log.info("sending message {}", message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }

}

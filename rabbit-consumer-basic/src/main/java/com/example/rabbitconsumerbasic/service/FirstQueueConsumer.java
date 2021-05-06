package com.example.rabbitconsumerbasic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FirstQueueConsumer {

	private static final Logger log = LoggerFactory.getLogger(FirstQueueConsumer.class);

	@RabbitListener(queues = {"FIRST-QUEUE-BASIC"})
    public void receiveMessageFromFirstQueue(Message message) {
    	log.info("receive message from {}", message.getMessageProperties().getConsumerQueue());
        String bodyAsString = new String(message.getBody());
        log.info("body {}", bodyAsString);
    }
	
}

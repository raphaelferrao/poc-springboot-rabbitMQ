/*
package com.example.rabbitconsumerbasic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class BasicListener implements MessageListener {

	private static final Logger log = LoggerFactory.getLogger(BasicListener.class);

    @Override 
    public void onMessage(Message message) {
        log.info("receive message from {}", message.getMessageProperties().getConsumerQueue());
        String bodyAsString = message.getBody().toString();
        log.info("body {}", bodyAsString);
    }
}
*/
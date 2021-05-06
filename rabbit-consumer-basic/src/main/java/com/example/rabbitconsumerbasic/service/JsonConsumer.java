package com.example.rabbitconsumerbasic.service;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rabbitconsumerbasic.model.Person;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonConsumer {

	private static final Logger log = LoggerFactory.getLogger(JsonConsumer.class);
	
	@Autowired
	private ModelMapper modelMapper;
	
    @RabbitListener(queues = {"JSON-QUEUE-BASIC"})
    void receiveMessageFromJsonQueue(Message message) throws IOException {
    	log.info("receive message from {}", message.getMessageProperties().getConsumerQueue());
    	JsonNode personNode = new ObjectMapper().readTree(message.getBody());
    	Person person = modelMapper.map(personNode, Person.class);
    	log.info("person {}", person);

    }
}
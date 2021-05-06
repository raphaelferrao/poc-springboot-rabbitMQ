package com.example.rabbitproducerbasic.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

	@Bean
	Queue firstQueue() {
		return QueueBuilder.durable("FIRST-QUEUE-BASIC").build();
	}

	@Bean
	Queue secondQueue() {
		return QueueBuilder.durable("SECOND-QUEUE-BASIC").build();
	}

	@Bean
	Queue jsonQueue() {
		return QueueBuilder.durable("JSON-QUEUE-BASIC").build();
	}

}

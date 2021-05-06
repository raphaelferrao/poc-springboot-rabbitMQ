package com.example.rabbitproducerbasic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {

	@Autowired
	private Queue firstQueue;
	
	@Autowired
    private Queue secondQueue;
	
	@Autowired
    private Queue jsonQueue;

    @Bean
    Exchange directExchange() {
        return ExchangeBuilder
            .directExchange("DIRECT-EXCHANGE-BASIC")
            .durable(true)
            .build();
    }

    @Bean
    Binding firstDirectBinding() {
        return BindingBuilder
            .bind(firstQueue)
            .to(directExchange())
            .with("TO-FIRST-QUEUE")
            .noargs();
    }

    @Bean
    Binding secondDirectBinding() {
        return BindingBuilder
            .bind(secondQueue)
            .to(directExchange())
            .with("TO-SECOND-QUEUE")
            .noargs();
    }

    @Bean
    Binding jsonDirectBinding() {
        return BindingBuilder
            .bind(jsonQueue)
            .to(directExchange())
            .with("TO-JSON-QUEUE")
            .noargs();
    }
}
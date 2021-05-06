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
public class FanoutConfig {

	@Autowired
	private Queue firstQueue;
	
	@Autowired
	private Queue secondQueue;

	@Bean
	Exchange fanoutExchange() {
		return ExchangeBuilder.fanoutExchange("FANOUT-EXCHANGE-BASIC").durable(true).build();
	}

	@Bean
	Binding firstFanoutBinding() {
		return BindingBuilder.bind(firstQueue).to(fanoutExchange()).with("").noargs();
	}

	@Bean
	Binding secondFanoutBinding() {
		return BindingBuilder.bind(secondQueue).to(fanoutExchange()).with("").noargs();
	}
}

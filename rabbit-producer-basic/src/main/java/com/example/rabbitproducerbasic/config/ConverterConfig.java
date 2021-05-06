package com.example.rabbitproducerbasic.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ConverterConfig {

	@Bean
	MessageConverter messageConverter(ObjectMapper objectMapper)  {
        return new Jackson2JsonMessageConverter(objectMapper); 
    }
	
}

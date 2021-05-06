package com.example.rabbitconsumerbasic.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.modelmapper.module.jdk8.Jdk8Module;
import org.modelmapper.module.jsr310.Jsr310Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.getConfiguration().addValueReader(new JsonNodeValueReader());
		
		modelMapper.registerModule(new Jsr310Module());
		modelMapper.registerModule(new Jdk8Module());
	    
		return modelMapper;
	}
}
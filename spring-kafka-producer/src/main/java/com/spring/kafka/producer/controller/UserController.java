package com.spring.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.producer.model.User;

@RestController
@RequestMapping("/kafka")
public class UserController {

	@Autowired	
	private KafkaTemplate<String, User> kafkaTemplate;
	private static final String TOPIC="test-topic1";
	
	
	@RequestMapping(value = "/publish/{name}")
	public String post(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new User(name, "Technology", 20500L));
		return "publish Successfully";
		
	}
	
}

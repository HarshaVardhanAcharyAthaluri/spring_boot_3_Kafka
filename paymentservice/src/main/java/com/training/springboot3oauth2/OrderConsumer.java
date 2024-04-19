package com.training.springboot3oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderConsumer {

	@Autowired
	ObjectMapper objmapper;
	
	@KafkaListener(topics = "any-topic-name", groupId = "your-consumer-group-id")
    public void consumeMessage(String order) throws JsonMappingException, JsonProcessingException {
		Order ordermessage = objmapper.readValue(order, Order.class);
		
        System.out.println("Received message: " + ordermessage);
    }
}

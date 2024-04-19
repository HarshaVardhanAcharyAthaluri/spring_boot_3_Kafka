package com.training.springboot3oauth2;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class OrderProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME= "any-topic-name"; // Replace with your desired topic name
    
    @Autowired
    private ObjectMapper objectMapper;

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message " + message +
             " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }
    
    public void sendOrder(Order order) throws JsonProcessingException {
    	String orderjson = objectMapper.writeValueAsString(order);
        kafkaTemplate.send(TOPIC_NAME, orderjson);
        System.out.println("Message " + orderjson +
             " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }
}

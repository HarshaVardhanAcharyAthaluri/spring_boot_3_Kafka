package com.training.springboot3oauth2;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;
    private final String TOPIC_NAME= "any-topic-name"; // Replace with your desired topic name

    public OrderProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        System.out.println("Message " + message +
             " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }
}

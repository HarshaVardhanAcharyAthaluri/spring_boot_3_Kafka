package com.training.springboot3oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	@KafkaListener(topics = "any-topic-name", groupId = "your-consumer-group-id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
        this.webSocket.convertAndSend("",message);
    }
}

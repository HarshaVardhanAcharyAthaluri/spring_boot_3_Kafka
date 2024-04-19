package com.training.springboot3oauth2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class OrderController {
	private final OrderProducer kafkaProducer;

    public OrderController(OrderProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
	
	@PostMapping("/save")
	public Order save(@RequestBody Order order) throws JsonProcessingException {
		System.out.println("order recevied");
		kafkaProducer.sendOrder(order);
		return order;
	}
	
	@GetMapping("/hello")
	public String greet() {
		return "Hello";
	}
}

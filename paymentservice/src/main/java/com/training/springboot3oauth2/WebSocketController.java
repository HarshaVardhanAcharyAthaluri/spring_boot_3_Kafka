package com.training.springboot3oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
	
	@Autowired
	SimpMessagingTemplate messagingTemplate;
	
	@GetMapping("/notify")
	public String greetmsg() {
		messagingTemplate.convertAndSend("/greettopic/hello","Hello Iam Harsha");
		return "Hello";
	}

	@MessageMapping("/hello")
	@SendTo("/greettopic/hello")
	public String greet() {
		return "Hello";
	}
	
	
}

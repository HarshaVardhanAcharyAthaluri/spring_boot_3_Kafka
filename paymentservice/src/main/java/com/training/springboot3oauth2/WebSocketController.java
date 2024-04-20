package com.training.springboot3oauth2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {
	
	@Autowired
	SimpMessagingTemplate messagingTemplate;
	
	@PostMapping("/notify")
	public String greetmsg(@RequestBody String msg) {
		messagingTemplate.convertAndSend("/greettopic/hello",msg);
		return "Hello";
	}

}

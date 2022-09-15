package com.kafkacon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class KafkaConApplication {

	List<String> messages = new ArrayList<>();
	
	@GetMapping("/consume")
	public List<String> consumeMsg(){
		return messages;
	}
	
	@KafkaListener(groupId="NithinOnCode-1",topics="java-p3r1",containerFactory="concurrentKafkaListenerContainerFactory")
	public List<String> getMsgFromTpc(String data) {
		messages.add(data);
		return messages;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaConApplication.class, args);
	}

}

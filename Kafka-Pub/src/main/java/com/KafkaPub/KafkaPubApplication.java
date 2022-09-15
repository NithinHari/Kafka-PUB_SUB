package com.KafkaPub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafkaPubApplication {
	@Autowired
	private KafkaTemplate<String, Object> template;
	@Autowired
	private KafkaTemplate<Integer, Object> templateInt;
	private String topic = "java-p3r1";


	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name){
		template.send(topic,"Hi "+name+", Glad to meet you!!");
		return "Data published";
	}
	@GetMapping("publish/{name}/{num}")
	public String publishMessageInt(@PathVariable int num,@PathVariable String name){
		templateInt.send(topic,"Hi "+name+" Port number is "+num);
		return "Port number published " +name+":"+num;
	}
//
	@GetMapping("/publishJson")
	public String publishMessage(){
		//UserModel um = new UserModel(123, "Nit1", new String[] {"Bangalore","Maruthi","House 1"});
		//UserModel um = new UserModel(123, "Nit1", new String[] {"Bangalore","Maruthi","House 1"});
		//template.send(topic, um);
		return "Json Data published";
	}



	public static void main(String[] args) {
		SpringApplication.run(KafkaPubApplication.class, args);
	}



}

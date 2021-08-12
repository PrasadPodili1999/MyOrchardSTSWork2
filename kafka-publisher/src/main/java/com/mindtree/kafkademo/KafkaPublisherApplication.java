package com.mindtree.kafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kafkademo.model.User;

@SpringBootApplication
@RestController
public class KafkaPublisherApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	private String topic="kafkademo";
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name)
	{
		template.send(topic, "Hi"+name+"welcome");
		return "Data Published";
	}
	
	@GetMapping("/publishJson")
	public String publishMessage()
	{
		User user=new User(1, "smith", new String[] {"Andhrapradesh","Chittor","Puttur","Shop Street","14-3"});
		template.send(topic, user);
		return "Json Data Published";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(KafkaPublisherApplication.class, args);
	}

}

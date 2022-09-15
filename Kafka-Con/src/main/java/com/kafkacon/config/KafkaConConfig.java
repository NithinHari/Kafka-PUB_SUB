package com.kafkacon.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.kafkacon.UserModel;

@Configuration
@EnableKafka
public class KafkaConConfig {
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> configs = new HashMap<>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "NithinOnCode-1");
		return new DefaultKafkaConsumerFactory<>(configs);
	}
	 
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	
//	@Bean
//	public ConsumerFactory<String, UserModel> userConsumerFactory(){
//		Map<String, Object> configs = new HashMap<>();
//		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
//		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "NithinOnCode-1");
//		return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>(UserModel.class));
//	}
	 
//	@Bean
//	public ConcurrentKafkaListenerContainerFactory<String,String> userConcurrentKafkaListenerContainerFactory(){
//		ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory();
//		factory.setConsumerFactory(consumerFactory());
//		return factory;
//	}
}

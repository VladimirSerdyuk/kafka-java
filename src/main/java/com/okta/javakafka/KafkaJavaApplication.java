package com.okta.javakafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Источники:
// https://developer.okta.com/blog/2019/11/19/java-kafka
// https://github.com/oktadeveloper/okta-java-kafka-example

@SpringBootApplication
public class KafkaJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaJavaApplication.class, args);
	}

}

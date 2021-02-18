package com.okta.javakafka.controller;

import com.okta.javakafka.consumer.MyTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {
    private KafkaTemplate<String, String> template;
    private MyTopicConsumer myTopicConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MyTopicConsumer myTopicConsumer) {
        this.template = template;
        this.myTopicConsumer = myTopicConsumer;
    }

    @GetMapping("/kafka/produce") // Request: http://localhost:8080/kafka/produce?message=This is my message
    public void produce(@RequestParam String message) {
        System.out.println("Message successfully received through the browser. Message text: \""+message+"\"");
        template.send("myTopic", message);
    }

    @GetMapping("/kafka/messages") // http://localhost:8080/kafka/messages
    public List<String> getMessages() {
        System.out.println("List of received messages: "+myTopicConsumer.getMessages());
        return myTopicConsumer.getMessages();
    }
}
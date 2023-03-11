package com.emresahna;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "first-topic", groupId = "group_foo")
    void listener(String data){
        System.out.println("Message received: " + data);
    }
}

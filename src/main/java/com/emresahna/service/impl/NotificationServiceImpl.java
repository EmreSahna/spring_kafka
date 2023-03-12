package com.emresahna.service.impl;

import com.emresahna.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    @Override
    @KafkaListener(topics = "transfer-notification", groupId = "group_foo")
    public void sendNotification(String data){
        logger.info("Payment occurred: " + data);
    }
}

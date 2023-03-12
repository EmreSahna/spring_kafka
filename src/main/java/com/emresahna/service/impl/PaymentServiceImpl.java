package com.emresahna.service.impl;

import com.emresahna.dto.PaymentRequest;
import com.emresahna.service.PaymentService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String pay(PaymentRequest paymentRequest) {
        String message = paymentRequest.from() + " paid " + paymentRequest.to() + " " + paymentRequest.amount() + " " + paymentRequest.currency();
        kafkaTemplate.send("transfer-notification", message);
        return "Payment successful.";
    }
}

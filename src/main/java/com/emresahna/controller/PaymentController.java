package com.emresahna.controller;

import com.emresahna.dto.PaymentRequest;
import com.emresahna.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("pay")
    public String pay(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.pay(paymentRequest);
    }
}

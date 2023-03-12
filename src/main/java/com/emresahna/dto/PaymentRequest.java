package com.emresahna.dto;

import java.math.BigDecimal;

public record PaymentRequest(String details, BigDecimal amount, String currency, String from, String to) {}
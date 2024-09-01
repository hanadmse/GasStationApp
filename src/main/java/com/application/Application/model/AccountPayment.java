package com.application.Application.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class AccountPayment extends AccountTransaction {
    @Column(unique = true, nullable = false)
    private final String paymentNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private final PaymentType paymentType;

    protected AccountPayment() {
        this.paymentNumber = null;
        this.paymentType = null;
    }

    public AccountPayment(AccountHolder accountHolder, AccountPaymentDTO data) {
        super(accountHolder, data.getPaymentDate(), TransactionType.PAYMENT, data.getAmount());
        this.paymentNumber = UUID.randomUUID().toString();
        this.paymentType = data.getPaymentType();
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

}

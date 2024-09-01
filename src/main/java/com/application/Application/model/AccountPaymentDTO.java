package com.application.Application.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountPaymentDTO {
    private final long accountHolderId;
    private final LocalDate paymentDate;
    private final PaymentType paymentType;
    private final BigDecimal amount;

    public AccountPaymentDTO(long accountHolderId, LocalDate paymentDate, PaymentType paymentType, BigDecimal amount) {
        this.accountHolderId = accountHolderId;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public long getAccountHolderId() {
        return accountHolderId;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

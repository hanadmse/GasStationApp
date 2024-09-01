package com.application.Application.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private final AccountHolder accountHolder;

    @Column(nullable = false)
    private final LocalDate transactionDate;

    @Column(nullable = false)
    private final TransactionType transactionType;

    @Column(nullable = false)
    private final BigDecimal transactionAmount;

    protected AccountTransaction() {
        this.accountHolder = null;
        this.transactionDate = null;
        this.transactionType = null;
        this.transactionAmount = null;
    }

    public AccountTransaction(AccountHolder accountHolder, LocalDate transactionDate, TransactionType transactionType, BigDecimal transactionAmount) {
        this.accountHolder = accountHolder;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

}

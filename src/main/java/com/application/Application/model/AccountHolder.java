package com.application.Application.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private final String name;
    @Column(nullable = false)
    private final String email;
    @Column(nullable = false)
    private final String phone;

    @Column(nullable = false)
    private BigDecimal accBalance;

    public AccountHolder(String name, BigDecimal accBalance, String email, String phone) {
        this.name = name;
        this.accBalance = accBalance;
        this.email = email;
        this.phone = phone;
    }

    protected AccountHolder() {
        this.name = null;
        this.email = null;
        this.phone = null;
    }

    public BigDecimal getAccBalance() {
        return accBalance;
    }

    public void updateAccBalance(BigDecimal newBalance) {
        if (newBalance == null) {
            throw new IllegalArgumentException("New balance cannot be null");
        }
        accBalance = newBalance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

}

package com.application.Application.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
public class AccountWithdrawal extends AccountTransaction{
    private final Long withdrawalNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, updatable = false)
    private final ShiftIdentifier shiftIdentifier;

    private final String licensePlateNumber;

    @Enumerated(EnumType.ORDINAL)
    private final FuelType fuelType;
    private final BigDecimal volume;

    public AccountWithdrawal(ShiftIdentifier shiftIdentifier, AccountHolder accountHolder, AccWithdrawalsDTO data) {
        super(accountHolder, shiftIdentifier.getDate(), TransactionType.WITHDRAWAL, data.getAmount());
        this.withdrawalNumber = data.getAccWithdrawalId();
        this.shiftIdentifier = shiftIdentifier;
        this.licensePlateNumber = data.getLicensePlateNumber();
        this.fuelType = data.getFuelType();
        this.volume = data.getVolume();
    }

    protected AccountWithdrawal() {
        this.withdrawalNumber = null;
        this.shiftIdentifier = null;
        this.licensePlateNumber = null;
        this.fuelType = null;
        this.volume = null;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public long getWithdrawalNumber() {
        return withdrawalNumber;
    }

    public ShiftIdentifier getShiftIdentifier() {
        return shiftIdentifier;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public BigDecimal getVolume() {
        return volume;
    }

}

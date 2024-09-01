package com.application.Application.model;

import java.math.BigDecimal;

public class AccWithdrawalsDTO {

    private final Long accWithdrawalId;
    private final Long accountHolderId;
    private final String licensePlateNumber;
    private final FuelType fuelType;
    private final BigDecimal volume;
    private final BigDecimal amount;

    public AccWithdrawalsDTO(Long accWithdrawalId, long accountHolderId, String licensePlateNumber, FuelType fuelType, BigDecimal volume) {
        this.accWithdrawalId = accWithdrawalId;
        this.accountHolderId = accountHolderId;
        this.licensePlateNumber = licensePlateNumber;
        this.fuelType = fuelType;
        this.volume = volume;
        this.amount = volume.multiply(fuelType.getRate());
    }

    public Long getAccWithdrawalId() {
        return accWithdrawalId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public long getAccountHolderId() {
        return accountHolderId;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

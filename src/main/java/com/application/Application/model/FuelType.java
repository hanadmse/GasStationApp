package com.application.Application.model;

import java.math.BigDecimal;

public enum FuelType {
    PETROL(new BigDecimal("31.58")),
    DIESEL(new BigDecimal("29.34"));

    private final BigDecimal rate;

    FuelType(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }
}

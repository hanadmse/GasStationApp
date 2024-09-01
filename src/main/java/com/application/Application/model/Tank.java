package com.application.Application.model;

import jakarta.persistence.*;

@Entity
public class Tank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tankId;

    private final int tankNum;

    @Enumerated(EnumType.STRING)
    private final FuelType fuelType;

    protected Tank() {
        this.tankNum = 0;
        this.fuelType = null;
    }

    public Tank(int tankNum, FuelType fuelType) {
        this.tankNum = tankNum;
        this.fuelType = fuelType;
    }

    public long getTankId() {
        return tankId;
    }

    public int getTankNum() {
        return tankNum;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

}

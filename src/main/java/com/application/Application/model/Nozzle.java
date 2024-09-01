package com.application.Application.model;

import jakarta.persistence.*;

@Entity
public class Nozzle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long nozzleId;

    @Column(name = "nozzle_name")
    private final String name;

    @Enumerated(EnumType.STRING)
    private final FuelType fuelType;

    protected Nozzle() {
        this.name = null;
        this.fuelType = null;
    }

    public Nozzle(String name, FuelType fuelType) {
        this.name = name;
        this.fuelType = fuelType;
    }

    public long getNozzleId() {
        return nozzleId;
    }

    public String getName() {
        return name;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

}


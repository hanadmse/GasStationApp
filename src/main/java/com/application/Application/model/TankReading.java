package com.application.Application.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Entity
public class TankReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id",  nullable = false)
    private final ShiftIdentifier shiftIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tank_id",  nullable = false)
    private final Tank tank;

    private final BigDecimal offloadedVolume;
    private final BigDecimal openReading;
    private final BigDecimal closeReading;

    protected TankReading() {
        this.shiftIdentifier = null;
        this.tank = null;
        this.offloadedVolume = null;
        this.openReading = null;
        this.closeReading = null;
    }

    public TankReading(ShiftIdentifier shiftIdentifier, Tank tank, TankReadingDTO data) {
        this.shiftIdentifier = shiftIdentifier;
        this.tank = tank;
        this.offloadedVolume = data.getOffloadedVolume();
        this.openReading = data.getOpenReading();
        this.closeReading = data.getCloseReading();
    }

    public long getId() {
        return id;
    }

    public ShiftIdentifier getShift() {
        return shiftIdentifier;
    }

    public Tank getTank() {
        return tank;
    }

    public BigDecimal getOffloadedVolume() {
        return offloadedVolume;
    }

    public BigDecimal getOpenReading() {
        return openReading;
    }

    public BigDecimal getCloseReading() {
        return closeReading;
    }

    public BigDecimal calculateTankMovement() {
        return (openReading.add(offloadedVolume)).subtract(closeReading);
    }

}

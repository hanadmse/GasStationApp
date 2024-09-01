package com.application.Application.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class NozzleReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id", nullable = false)
    private final ShiftIdentifier shiftIdentifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nozzle_id", nullable = false)
    private final Nozzle nozzle;

    private final BigDecimal pOpenMeter;
    private final BigDecimal pCloseMeter;
    private final BigDecimal lOpenMeter;
    private final BigDecimal lCloseMeter;
    private final BigDecimal mOpenMeter;
    private final BigDecimal mCloseMeter;

    protected NozzleReading() {
        this.shiftIdentifier = null;
        this.nozzle = null;
        this.pOpenMeter = null;
        this.pCloseMeter = null;
        this.lOpenMeter = null;
        this.lCloseMeter = null;
        this.mOpenMeter = null;
        this.mCloseMeter = null;
    }

    public NozzleReading(ShiftIdentifier shiftIdentifier, Nozzle nozzle, NozzleReadingDTO data) {
        this.shiftIdentifier = shiftIdentifier;
        this.nozzle = nozzle;
        this.pOpenMeter = data.getpOpenMeter();
        this.pCloseMeter = data.getpCloseMeter();
        this.lOpenMeter = data.getlOpenMeter();
        this.lCloseMeter = data.getlCloseMeter();
        this.mOpenMeter = data.getmOpenMeter();
        this.mCloseMeter = data.getmCloseMeter();
    }

    public long getId() {
        return id;
    }

    public ShiftIdentifier getShift() {
        return shiftIdentifier;
    }

    public Nozzle getNozzle() {
        return nozzle;
    }

    public BigDecimal getpOpenMeter() {
        return pOpenMeter;
    }

    public BigDecimal getpCloseMeter() {
        return pCloseMeter;
    }

    public BigDecimal getlOpenMeter() {
        return lOpenMeter;
    }

    public BigDecimal getlCloseMeter() {
        return lCloseMeter;
    }

    public BigDecimal getmOpenMeter() {
        return mOpenMeter;
    }

    public BigDecimal getmCloseMeter() {
        return mCloseMeter;
    }

    public BigDecimal calculateVolume() {
        BigDecimal mVolume = mCloseMeter.subtract(mOpenMeter);
        BigDecimal lVolume = lCloseMeter.subtract(lOpenMeter);
        return mVolume.max(lVolume);
    }

    public BigDecimal calculateSales() {
        BigDecimal maxVolume = calculateVolume();
        BigDecimal pAmount = pCloseMeter.subtract(pOpenMeter);
        BigDecimal volAmount =  maxVolume.multiply(nozzle.getFuelType().getRate());
        return pAmount.max(volAmount);
    }

    @Override
    public String toString() {
        return "NozzleReading{" +
                "id=" + id +
                ", shift=" + shiftIdentifier +
                ", nozzle=" + nozzle +
                ", pOpenMeter=" + pOpenMeter +
                ", pCloseMeter=" + pCloseMeter +
                ", lOpenMeter=" + lOpenMeter +
                ", lCloseMeter=" + lCloseMeter +
                ", mOpenMeter=" + mOpenMeter +
                ", mCloseMeter=" + mCloseMeter +
                '}';
    }
}

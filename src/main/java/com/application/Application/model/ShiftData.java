package com.application.Application.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class ShiftData {
    @Id
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private final ShiftIdentifier shiftIdentifier;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private final List<NozzleReading> nozzleReadings;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private final List<TankReading> tankReadings;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private final List<AccountWithdrawal> accountWithdrawals;

    private final BigDecimal totalAmount;
    private final BigDecimal totalVolume;
    private final BigDecimal totalDAmount;
    private final BigDecimal totalDVolume;
    private final BigDecimal totalPAmount;
    private final BigDecimal totalPVolume;
    private final BigDecimal totalAccountWith;
    private final BigDecimal totalCash;
    private final BigDecimal tank1StockVariance;
    private final BigDecimal tank2StockVariance;
    private final BigDecimal tank3StockVariance;
    private final BigDecimal tank4StockVariance;

    public ShiftData(ShiftIdentifier shiftIdentifier, List<NozzleReading> nozzleReadings, List<TankReading> tankReadings, List<AccountWithdrawal> accountWithdrawals, List<BigDecimal> shiftFigures) {
        this.shiftIdentifier = shiftIdentifier;
        this.nozzleReadings = nozzleReadings;
        this.tankReadings = tankReadings;
        this.accountWithdrawals = accountWithdrawals;
        totalAmount = shiftFigures.get(0);
        totalVolume = shiftFigures.get(1);
        totalDAmount = shiftFigures.get(2);
        totalDVolume = shiftFigures.get(3);
        totalPAmount = shiftFigures.get(4);
        totalPVolume = shiftFigures.get(5);
        totalAccountWith = shiftFigures.get(6);
        totalCash = shiftFigures.get(7);
        tank1StockVariance = shiftFigures.get(8);
        tank2StockVariance = shiftFigures.get(9);
        tank3StockVariance = shiftFigures.get(10);
        tank4StockVariance = shiftFigures.get(11);
    }

    protected ShiftData() {
        this.id = null;
        this.shiftIdentifier = null;
        this.nozzleReadings = null;
        this.tankReadings = null;
        this.accountWithdrawals = null;
        this.totalAmount = null;
        this.totalVolume = null;
        this.totalDAmount = null;
        this.totalDVolume = null;
        this.totalPAmount = null;
        this.totalPVolume = null;
        this.totalAccountWith = null;
        this.totalCash = null;
        this.tank1StockVariance = null;
        this.tank2StockVariance = null;
        this.tank3StockVariance = null;
        this.tank4StockVariance = null;
    }

    public Long getId() {
        return id;
    }

    public ShiftIdentifier getShift() {
        return shiftIdentifier;
    }

    public List<NozzleReading> getNozzleReadings() {
        return nozzleReadings;
    }

    public List<TankReading> getTankReadings() {
        return tankReadings;
    }

    public List<AccountWithdrawal> getAccountWithdrawals() {
        return accountWithdrawals;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public BigDecimal getTotalVolume() {
        return totalVolume;
    }

    public BigDecimal getTotalDAmount() {
        return totalDAmount;
    }

    public BigDecimal getTotalDVolume() {
        return totalDVolume;
    }

    public BigDecimal getTotalPVolume() {
        return totalPVolume;
    }

    public BigDecimal getTotalPAmount() {
        return totalPAmount;
    }

    public BigDecimal getTotalAccountWith() {
        return totalAccountWith;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public BigDecimal getTank1StockVariance() {
        return tank1StockVariance;
    }

    public BigDecimal getTank2StockVariance() {
        return tank2StockVariance;
    }

    public BigDecimal getTank3StockVariance() {
        return tank3StockVariance;
    }

    public BigDecimal getTank4StockVariance() {
        return tank4StockVariance;
    }

}

package com.application.Application.service;

import com.application.Application.model.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ShiftCalculatorService {

    public List<BigDecimal> calculateAllFigures(List<NozzleReading> nozzleReadings, List<TankReading> tankReadings, List<AccountWithdrawal> accountWithdrawals) {
        List<BigDecimal> salesFigures = calculateSalesFigures(nozzleReadings);
        List<BigDecimal> figures = new ArrayList<>(salesFigures.subList(0, 6));
        BigDecimal totalAmount = figures.get(0);
        BigDecimal totalAccountsWith = calculateTotalAccts(accountWithdrawals);
        figures.add(totalAccountsWith);
        figures.add(calculateTotalCash(totalAmount, totalAccountsWith));
        figures.addAll(calculateStockSalesVariance(tankReadings, salesFigures.subList(6, salesFigures.size())));
        return figures;
    }

    public List<BigDecimal> calculateSalesFigures(List<NozzleReading> nozzleReadings) {
        List<BigDecimal> salesFigures = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal totalVolume = BigDecimal.ZERO;
        BigDecimal totalDAmount = BigDecimal.ZERO;
        BigDecimal totalDVolume = BigDecimal.ZERO;
        BigDecimal totalPAmount = BigDecimal.ZERO;
        BigDecimal totalPVolume = BigDecimal.ZERO;

        BigDecimal tank1NozzlesVolume = BigDecimal.ZERO;
        BigDecimal tank2NozzlesVolume = BigDecimal.ZERO;
        BigDecimal tank3NozzlesVolume = BigDecimal.ZERO;
        BigDecimal tank4NozzlesVolume = BigDecimal.ZERO;

        for (NozzleReading nozzleReading : nozzleReadings) {
            BigDecimal nozzleAmount = nozzleReading.calculateSales();
            BigDecimal nozzleVolume = nozzleReading.calculateVolume();

            if (nozzleReading.getNozzle().getFuelType().equals(FuelType.PETROL)) {
                totalPAmount = totalPAmount.add(nozzleAmount);
                totalPVolume = totalPVolume.add(nozzleVolume);
            }
            else if (nozzleReading.getNozzle().getFuelType().equals(FuelType.DIESEL)){
                totalDAmount = totalDAmount.add(nozzleAmount);
                totalDVolume = totalDVolume.add(nozzleVolume);
            }

            if (nozzleReading.getNozzle().getNozzleId() == 1L || nozzleReading.getNozzle().getNozzleId() == 2L) {
                tank1NozzlesVolume = tank1NozzlesVolume.add(nozzleVolume);
            }
            else if (nozzleReading.getNozzle().getNozzleId() == 3L || nozzleReading.getNozzle().getNozzleId() == 4L) {
                tank2NozzlesVolume = tank2NozzlesVolume.add(nozzleVolume);
            }
            else if (nozzleReading.getNozzle().getNozzleId() == 5L || nozzleReading.getNozzle().getNozzleId() == 6L) {
                tank3NozzlesVolume = tank3NozzlesVolume.add(nozzleVolume);
            }
            else if (nozzleReading.getNozzle().getNozzleId() == 7L || nozzleReading.getNozzle().getNozzleId() == 8L) {
                tank4NozzlesVolume = tank4NozzlesVolume.add(nozzleVolume);
            }
        }
        totalAmount = totalDAmount.add(totalPAmount);
        totalVolume = totalDVolume.add(totalPVolume);
        salesFigures.add(totalAmount);
        salesFigures.add(totalVolume);
        salesFigures.add(totalDAmount);
        salesFigures.add(totalDVolume);
        salesFigures.add(totalPAmount);
        salesFigures.add(totalPVolume);
        salesFigures.add(tank1NozzlesVolume);
        salesFigures.add(tank2NozzlesVolume);
        salesFigures.add(tank3NozzlesVolume);
        salesFigures.add(tank4NozzlesVolume);
        return salesFigures;
    }

    public BigDecimal calculateTotalAccts(List<AccountWithdrawal> accountWithdrawals) {
        BigDecimal totalAccountWith = BigDecimal.ZERO;
        for (AccountWithdrawal withdrawal : accountWithdrawals) {
            totalAccountWith = totalAccountWith.add(withdrawal.getTransactionAmount());
        }
        return totalAccountWith;
    }

    public BigDecimal calculateTotalCash(BigDecimal totalAmount, BigDecimal totalAccountWith) {
        return totalAmount.subtract(totalAccountWith);
    }

    public List<BigDecimal> calculateStockSalesVariance(List<TankReading> tankReadings, List<BigDecimal> nozzlesVolume) {
        List<BigDecimal> stockSalesVariances = new ArrayList<>();
        int index = 0;
        for (TankReading tankReading : tankReadings) {
            BigDecimal nozzlesVol = nozzlesVolume.get(index++);
            BigDecimal variance = nozzlesVol.subtract(tankReading.calculateTankMovement());
            stockSalesVariances.add(variance);
        }
        return stockSalesVariances;
    }


}

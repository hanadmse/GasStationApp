package com.application.Application.service;

import com.application.Application.model.*;
import com.application.Application.repo.ShiftDataRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShiftDataService {
    private ShiftIdService shiftIdService;
    private ShiftDataRepo shiftDataRepo;
    private NozzleReadingService nozzleReadingService;
    private TankReadingService tankReadingService;
    private AccTransactionService accTransactionService;
    private ShiftCalculatorService shiftCalculatorService;

    public ShiftDataService(ShiftIdService shiftIdService, ShiftDataRepo shiftDataRepo, NozzleReadingService nozzleReadingService, TankReadingService tankReadingService, ShiftCalculatorService shiftCalculatorService, AccTransactionService accTransactionService) {
        this.shiftIdService = shiftIdService;
        this.shiftDataRepo = shiftDataRepo;
        this.nozzleReadingService = nozzleReadingService;
        this.tankReadingService = tankReadingService;
        this.shiftCalculatorService = shiftCalculatorService;
        this.accTransactionService = accTransactionService;
    }

    public List<ShiftData> getAllShiftData() {
      return shiftDataRepo.findAll();
    }

    public ShiftData getShiftData(long id) {
        return shiftDataRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Shift data not found with ID: " + id));
    }

    @Transactional
    public void createShiftData(ShiftDataDTO data) {
        ShiftIdentifier shiftIdentifier = shiftIdService.getShiftId(data.getShiftId());
        List<NozzleReading> nozzleReadings =  nozzleReadingService.addNozzleReadingsAsList(shiftIdentifier, data.getNozzleReadingData());
        List<TankReading> tankReadings = tankReadingService.addTankReadingsAsList(shiftIdentifier, data.getTankReadingData());
        List<AccountWithdrawal> accountWithdrawals = accTransactionService.addWithdrawalsAsList(shiftIdentifier, data.getAccountWithdrawalData());
        List<BigDecimal> shiftFigures = calculateFigures(nozzleReadings, tankReadings, accountWithdrawals);
        ShiftData shiftData = new ShiftData(shiftIdentifier, nozzleReadings, tankReadings, accountWithdrawals, shiftFigures);
        shiftDataRepo.save(shiftData);
    }

    public List<BigDecimal> calculateFigures(List<NozzleReading> nozzleReadings, List<TankReading> tankReadings, List<AccountWithdrawal> accountWithdrawals) {
        return shiftCalculatorService.calculateAllFigures(nozzleReadings, tankReadings, accountWithdrawals);
    }

    @Transactional
    public void updateShiftData(long id, ShiftDataDTO data) {
        if (!shiftDataRepo.existsById(id)) {
            throw new EntityNotFoundException("Shift data not found with ID: " + id);
        }
        deleteData(id);
        createShiftData(data);
    }

    @Transactional
    public void deleteData(long id) {
        if (!shiftDataRepo.existsById(id)) {
            throw new EntityNotFoundException("Shift data not found with ID: " + id);
        }
        ShiftData shiftData = getShiftData(id);
        List<AccountWithdrawal> accountWithdrawals = shiftData.getAccountWithdrawals();
        for (AccountWithdrawal accountWithdrawal : accountWithdrawals) {
            AccountHolder accountHolder = accountWithdrawal.getAccountHolder();
            BigDecimal currBalance = accountHolder.getAccBalance();
            BigDecimal updatedBalance = currBalance.add(accountWithdrawal.getTransactionAmount());
            accountHolder.updateAccBalance(updatedBalance);
        }
        shiftDataRepo.deleteById(id);
    }
}

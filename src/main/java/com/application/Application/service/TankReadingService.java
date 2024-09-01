package com.application.Application.service;

import com.application.Application.model.*;
import com.application.Application.repo.TankReadingRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TankReadingService {
    private TankReadingRepo tankReadingRepo;
    private TankService tankService;

    public TankReadingService(TankReadingRepo tankReadingRepo, TankService tankService) {
        this.tankReadingRepo = tankReadingRepo;
        this.tankService = tankService;
    }

    public List<TankReading> getTankReadings() {
        return tankReadingRepo.findAll();
    }

    public TankReading getTankReadingById(long tankReadingId) {
        return tankReadingRepo.findById(tankReadingId)
                .orElseThrow(() -> new EntityNotFoundException("TankReading not found with ID: " + tankReadingId));
    }

    public List<TankReading> addTankReadingsAsList(ShiftIdentifier shiftIdentifier, List<TankReadingDTO> tankReadings) {
        List<TankReading> tankReadingList = new ArrayList<>();
        for (TankReadingDTO data : tankReadings) {
            Tank tank = tankService.getTankById(data.getTankId());
            TankReading tankReading = new TankReading(shiftIdentifier, tank, data);
            tankReadingList.add(tankReading);
        }
        tankReadingRepo.saveAll(tankReadingList);
        return tankReadingList;
    }

}

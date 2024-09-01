package com.application.Application.service;


import com.application.Application.model.*;
import com.application.Application.repo.ShiftIdRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftIdService {
    private ShiftIdRepo shiftIdRepo;
    private NozzleReadingService nozzleReadingService;
    private TankReadingService tankReadingService;
    private AccTransactionService accTransactionService;

    public ShiftIdService(ShiftIdRepo shiftIdRepo, NozzleReadingService nozzleReadingService, TankReadingService tankReadingService, AccTransactionService accTransactionService) {
        this.shiftIdRepo = shiftIdRepo;
        this.nozzleReadingService = nozzleReadingService;
        this.tankReadingService = tankReadingService;
        this.accTransactionService = accTransactionService;
    }

    public List<ShiftIdentifier> getAllShiftIds() {
        return shiftIdRepo.findAll();
    }

    public ShiftIdentifier getShiftId(long id) {
        return shiftIdRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShiftIdentifier not found with ID: " + id));
    }

    public Long addShiftId(ShiftIdentifier shiftIdentifier) {
        shiftIdRepo.save(shiftIdentifier);
        return shiftIdentifier.getId();
    }

    public void deleteShiftId(long id) {
        if (!shiftIdRepo.existsById(id)) {
            throw new EntityNotFoundException("ShiftIdentifier not found with ID: " + id);
        }
        shiftIdRepo.deleteById(id);
    }

}

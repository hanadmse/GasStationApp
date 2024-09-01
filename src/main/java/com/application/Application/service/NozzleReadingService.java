package com.application.Application.service;

import com.application.Application.model.Nozzle;
import com.application.Application.model.NozzleReading;
import com.application.Application.model.NozzleReadingDTO;
import com.application.Application.model.ShiftIdentifier;
import com.application.Application.repo.NozzleReadingRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NozzleReadingService {
    private NozzleReadingRepo nozzleReadingRepo;
    private NozzleService nozzleService;

    public NozzleReadingService(NozzleReadingRepo nozzleReadingRepo, NozzleService nozzleService) {
        this.nozzleReadingRepo = nozzleReadingRepo;
        this.nozzleService = nozzleService;
    }

    public List<NozzleReading> getNozzleReadings() {
        return nozzleReadingRepo.findAll();
    }

    public NozzleReading getNozzleReadingById(long nozzleReadingId){
        return nozzleReadingRepo.findById(nozzleReadingId)
                .orElseThrow(() -> new EntityNotFoundException("NozzleReading not found with ID: " + nozzleReadingId));
    }

    public List<NozzleReading> addNozzleReadingsAsList(ShiftIdentifier shiftIdentifier, List<NozzleReadingDTO> nozzleReadings) {
        List<NozzleReading> nozzleReadingList = new ArrayList<>();
        for (NozzleReadingDTO data : nozzleReadings) {
            Nozzle nozzle = nozzleService.getNozzleById(data.getNozzleId());
            NozzleReading nozzleReading = new NozzleReading(shiftIdentifier, nozzle, data);
            nozzleReadingList.add(nozzleReading);
        }
        nozzleReadingRepo.saveAll(nozzleReadingList);
        return nozzleReadingList;
    }
}

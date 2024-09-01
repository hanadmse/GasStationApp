package com.application.Application.service;

import com.application.Application.model.Nozzle;
import com.application.Application.repo.NozzleRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NozzleService {
    private NozzleRepo nozzleRepo;

    public NozzleService(NozzleRepo nozzleRepo) {
        this.nozzleRepo = nozzleRepo;
    }

    public List<Nozzle> getNozzles() {
        return nozzleRepo.findAll();
    }

    public Nozzle getNozzleById(long id){
        return nozzleRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nozzle not found with ID: " + id));
    }

    public void addNozzle(Nozzle nozzle) {
        nozzleRepo.save(nozzle);
    }

    public void updateNozzle(long nozzleId, Nozzle modifiedNozzle) {
        if (!nozzleRepo.existsById(nozzleId)) {
            throw new EntityNotFoundException("Nozzle not found with ID: " + nozzleId);
        }
        deleteNozzleById(nozzleId);
        Nozzle newNozzle = new Nozzle(modifiedNozzle.getName(), modifiedNozzle.getFuelType());
        addNozzle(newNozzle);
    }

    public void deleteNozzleById(long id) {
        if (!nozzleRepo.existsById(id)) {
            throw new EntityNotFoundException("Nozzle not found with ID: " + id);
        }
        nozzleRepo.deleteById(id);
    }
}

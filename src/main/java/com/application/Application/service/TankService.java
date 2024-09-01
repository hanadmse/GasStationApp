package com.application.Application.service;

import com.application.Application.model.Tank;
import com.application.Application.repo.TankRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankService {
    private TankRepo tankRepo;

    public TankService(TankRepo tankRepo) {
        this.tankRepo = tankRepo;
    }

    public List<Tank> getTanks() {
        return tankRepo.findAll();
    }

    public Tank getTankById(long id) {
        return tankRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tank not found with ID: " + id));
    }

    public void addTank(Tank tank) {
        tankRepo.save(tank);
    }

    public void updateTank(long tankId, Tank tank) {
        if (!tankRepo.existsById(tankId)) {
            throw new EntityNotFoundException("Tank not found with ID: " + tankId);
        }
        deleteTankById(tankId);
        addTank(tank);
    }

    public void deleteTankById(long id) {
        if (!tankRepo.existsById(id)) {
            throw new EntityNotFoundException("Tank not found with ID: " + id);
        }
        tankRepo.deleteById(id);
    }
}

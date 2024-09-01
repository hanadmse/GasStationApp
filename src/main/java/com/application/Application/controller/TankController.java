package com.application.Application.controller;

import com.application.Application.model.Nozzle;
import com.application.Application.model.Tank;
import com.application.Application.service.TankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tanks")
public class TankController {
    private TankService tankService;

    public TankController(TankService tankService) {
        this.tankService = tankService;
    }

    @GetMapping
    public List<Tank> getTanks() {
        return tankService.getTanks();
    }

    @GetMapping("/{tankId}")
    public Tank getTankById(@PathVariable long tankId) {
        return tankService.getTankById(tankId);
    }

    @PostMapping
    public void addTank(@RequestBody Tank tank) {
        tankService.addTank(tank);
    }

    @PutMapping("/{tankId}")
    public void updateTank(@PathVariable long tankId, @RequestBody Tank tank) {
        tankService.updateTank(tankId, tank);
    }

    @DeleteMapping("/{tankId}")
    public void deleteTankById(@PathVariable long tankId) {
        tankService.deleteTankById(tankId);
    }
}

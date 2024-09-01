package com.application.Application.controller;


import com.application.Application.model.*;
import com.application.Application.service.TankReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tankReadings")
public class TankReadingController {
    private TankReadingService tankReadingService;

    public TankReadingController(TankReadingService tankReadingService) {
        this.tankReadingService = tankReadingService;
    }

    @GetMapping
    public List<TankReading> getTankReadings() {
        return tankReadingService.getTankReadings();
    }

    @GetMapping("/{tankReadingId}")
    public TankReading getTankReadingById(@PathVariable long tankReadingId) {
        return tankReadingService.getTankReadingById(tankReadingId);
    }
}

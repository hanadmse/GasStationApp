package com.application.Application.controller;

import com.application.Application.model.NozzleReading;
import com.application.Application.service.NozzleReadingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nozzleReadings")
public class NozzleReadingController {
    private NozzleReadingService nozzleReadingService;

    public NozzleReadingController(NozzleReadingService nozzleReadingService) {
        this.nozzleReadingService = nozzleReadingService;
    }

    @GetMapping
    public List<NozzleReading> getNozzleReadings() {
        return nozzleReadingService.getNozzleReadings();
    }

    @GetMapping("/{nozzleReadingId}")
    public NozzleReading getNozzleReadingById(@PathVariable long nozzleReadingId) {
        return nozzleReadingService.getNozzleReadingById(nozzleReadingId);
    }

}

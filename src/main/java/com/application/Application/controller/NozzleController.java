package com.application.Application.controller;

import com.application.Application.model.Nozzle;
import com.application.Application.service.NozzleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nozzles")
public class NozzleController {
    private NozzleService nozzleService;

    public NozzleController(NozzleService nozzleService) {
        this.nozzleService = nozzleService;
    }

    @GetMapping
    public List<Nozzle> getNozzles() {
        return nozzleService.getNozzles();
    }

    @GetMapping("/{nozzleId}")
    public Nozzle getNozzleById(@PathVariable long nozzleId) {
        return nozzleService.getNozzleById(nozzleId);
    }

    @PostMapping
    public void addNozzle(@RequestBody Nozzle nozzle) {
        nozzleService.addNozzle(nozzle);
    }

    @PutMapping("/{nozzleId}")
    public void updateNozzle(@PathVariable long nozzleId, @RequestBody Nozzle modifiedNozzle) {
        nozzleService.updateNozzle(nozzleId, modifiedNozzle);
    }

    @DeleteMapping("/{nozzleId}")
    public void deleteNozzleById(@PathVariable long nozzleId) {
        nozzleService.deleteNozzleById(nozzleId);
    }
}

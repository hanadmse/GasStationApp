package com.application.Application.controller;

import com.application.Application.model.ShiftData;
import com.application.Application.model.ShiftDataDTO;
import com.application.Application.service.ShiftDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shiftData")
public class ShiftDataController {
    private ShiftDataService shiftDataService;

    public ShiftDataController(ShiftDataService shiftDataService) {
        this.shiftDataService = shiftDataService;
    }

    @GetMapping
    public List<ShiftData> getAllShiftData() {
        return shiftDataService.getAllShiftData();
    }

    @GetMapping("/{id}")
    public ShiftData getShiftData(@PathVariable long id) {
        return shiftDataService.getShiftData(id);
    }

    @PostMapping
    public void createShiftData(@RequestBody ShiftDataDTO data) {
        shiftDataService.createShiftData(data);
    }

    @PutMapping("/{id}")
    public void updateShiftData(@PathVariable long id, @RequestBody ShiftDataDTO data) {
        shiftDataService.updateShiftData(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteShiftData(@PathVariable long id) {
        shiftDataService.deleteData(id);
    }
}

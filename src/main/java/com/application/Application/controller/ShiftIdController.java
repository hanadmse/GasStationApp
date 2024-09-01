package com.application.Application.controller;

import com.application.Application.model.ShiftIdentifier;
import com.application.Application.service.ShiftIdService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shiftId")
public class ShiftIdController {
    private ShiftIdService shiftIdService;
    
    public ShiftIdController(ShiftIdService shiftIdService) {
        this.shiftIdService = shiftIdService;
    }

    @GetMapping
    public List<ShiftIdentifier> getAllShiftIds() {
        return shiftIdService.getAllShiftIds();
    }

    @GetMapping("/{shiftId}")
    public ShiftIdentifier getShiftId(@PathVariable long shiftId) {
        return shiftIdService.getShiftId(shiftId);
    }

    @PostMapping
    public void addShiftId(@RequestBody ShiftIdentifier shiftIdentifier) {
        shiftIdService.addShiftId(shiftIdentifier);
    }

    @DeleteMapping("/{shiftId}")
    public void deleteShiftId(@PathVariable long shiftId) {
        shiftIdService.deleteShiftId(shiftId);
    }
    
}

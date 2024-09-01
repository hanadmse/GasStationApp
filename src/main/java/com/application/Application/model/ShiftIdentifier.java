package com.application.Application.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ShiftIdentifier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDate date;

    @Enumerated(EnumType.STRING)
    private final ShiftPeriod shiftPeriod;

    protected ShiftIdentifier() {
        date = null;
        shiftPeriod = null;
    }

    public ShiftIdentifier(LocalDate date, ShiftPeriod shiftPeriod) {
        this.date = date;
        this.shiftPeriod = shiftPeriod;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public ShiftPeriod getShiftPeriod() {
        return shiftPeriod;
    }

}

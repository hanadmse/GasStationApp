package com.application.Application.model;

import java.math.BigDecimal;

public class TankReadingDTO {
    private final long tankId;
    private final BigDecimal openReading;
    private final BigDecimal offloadedVolume;
    private final BigDecimal closeReading;

    public TankReadingDTO(long tankId, BigDecimal openReading, BigDecimal offloadedVolume, BigDecimal closeReading) {
        this.tankId = tankId;
        this.openReading = openReading;
        this.offloadedVolume = offloadedVolume;
        this.closeReading = closeReading;
    }

    public long getTankId() {
        return tankId;
    }

    public BigDecimal getOpenReading() {
        return openReading;
    }

    public BigDecimal getOffloadedVolume() {
        return offloadedVolume;
    }

    public BigDecimal getCloseReading() {
        return closeReading;
    }

}
